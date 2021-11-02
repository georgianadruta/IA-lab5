package state;

import lombok.Data;
import lombok.ToString;
import players.Player;
import players.PlayerA;
import players.PlayerB;

import java.util.LinkedList;
import java.util.List;

@Data
@ToString
public class State {
    private final List<Integer> ballsList = new LinkedList<>();
    private PlayerA playerA;
    private PlayerB playerB;
    private Player winner = null;
    private int n;
    private int m;
    private int k;

    public void getWinnerInTheCurrentGame() {
        if (this.playerA != null && this.playerB != null) {
            int number = this.playerA.getNumberOfCommonBallsBetweenPlayerAAndPlayerB(this);
            if (number == this.k) {
                System.out.println("The winner is PlayerB.");
                this.winner = playerB;
                return;
            }
            this.winner = playerA;
            System.out.println("The winner is PlayerA.");
        }
    }

    public void initializeState(int n, int m, int k, PlayerA playerA, PlayerB playerB) {
        this.n = n;
        this.m = m;
        this.k = k;
        this.playerA = playerA;
        this.playerB = playerB;
        k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.ballsList.add(k);
            }
            k++;
        }
    }

    public Player isFinalState() {
        if (this.winner != null) {
            return winner;
        }
        System.out.println("It is not final state.");
        return null;
    }
}

package state;

import lombok.Data;
import players.Player;
import players.PlayerA;
import players.PlayerB;

import java.util.LinkedList;
import java.util.List;

@Data
public class State {
    private final List<Integer> ballsList = new LinkedList<>();
    private List<Integer> listA = new LinkedList<>();
    private List<Integer> listB = new LinkedList<>();
    private Player winner = null;
    private int n;
    private int m;
    private int k;

    public void getWinner(PlayerA playerA, PlayerB playerB) {
        for (int i = 0; i < 2 * this.n; i++) {
            this.listB = playerB.getChosenBalls(this);
            System.out.println("The chose list by B: " + this.listB);
            int number = playerA.getNumberOfCommonBallsBetweenAAndB(this);
            System.out.println("The number of common balls: " + number);
            if (number == this.k) {
                System.out.println("The winner is PlayerB.");
                this.winner = playerB;
                return;
            }
        }
        this.winner = playerA;
        System.out.println("The winner is PlayerA.");
    }

    public State initializeState(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
        k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.ballsList.add(k);
            }
            k++;
        }
        return this;
    }

    public boolean isFinalState() {
        return this.winner == null;
    }
}

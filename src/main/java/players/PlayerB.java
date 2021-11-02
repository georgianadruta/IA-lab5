package players;

import lombok.Data;
import lombok.EqualsAndHashCode;
import state.State;
import util.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@EqualsAndHashCode(callSuper = true)
@Data
public class PlayerB extends Player {
    private List<Integer> ballList = new LinkedList<>();

    public void setListFromHumanPlayer(State state) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < state.getK(); i++) {
            System.out.print("Give a natural value < n: ");
            list.add(in.nextInt());
        }
        while (Utils.isNotValidColorList(list, state.getN(), state.getM())) {
            System.out.println("Invalid list.");
            for (int i = 0; i < state.getK(); i++) {
                System.out.print("Give a natural value < n: ");
                list.add(in.nextInt());
            }
        }
        System.out.println("B: " + list);
        this.ballList = list;
    }

    public void setListFromBotPlayer(State state) {
        for (int i = 0; i < 2 * state.getN(); i++) {
            this.ballList = this.getKBallsByBotPlayer(state);
            System.out.println("B: " + this.ballList);
            int number = state.getPlayerA().getNumberOfCommonBallsBetweenPlayerAAndPlayerB(state);
            System.out.println("The number of common balls: " + number);
            if (number == state.getK()) {
                System.out.println("The winner is PlayerB.");
                state.setWinner(this);
                return;
            }
        }
        state.setWinner(state.getPlayerA());
        System.out.println("The winner is PlayerA.");
    }
}

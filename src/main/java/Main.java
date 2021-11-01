import players.PlayerA;
import players.PlayerB;
import state.State;
import util.Utils;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Give a natural value for n: ");
        int n = in.nextInt();

        System.out.print("Give a natural value for m: ");
        int m = in.nextInt();

        System.out.print("Give a natural value for k: ");
        int k = in.nextInt();

        if (n < 0 || m < 0 || k < 0) {
            throw new IllegalArgumentException();
        }

        State state = new State();
        System.out.println("Initial state: " + state.initializeState(n, m, k));
        PlayerA playerA = new PlayerA();
        PlayerB playerB = new PlayerB();

        state.setListA(playerA.getChosenBalls(state));
        System.out.println("The chose list by A: " + state.getListA());
        state.getWinner(playerA, playerB);

        System.out.println("Final state: " + state.isFinalState());


        List<Integer> list = Utils.readListFromHuman(k, n, m);
        System.out.println("List A equals list from human? " + playerA.getNumberOfCommonBallsBetweenAAndAListFromHuman(state, list));
    }
}

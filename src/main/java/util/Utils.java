package util;

import players.PlayerA;
import players.PlayerB;
import state.State;

import java.util.*;

public class Utils {

    public static boolean isNotValidColorList(List<Integer> list, int n, int m) {
        return hasMaxValueBiggerThanN(list, n) && hasMoreRepeatedValuesThanM(list, m);
    }

    private static boolean hasMaxValueBiggerThanN(List<Integer> list, int n) {
        int max = getMax(list);
        return max >= n;
    }

    private static boolean hasMoreRepeatedValuesThanM(List<Integer> list, int m) {
        int max = getMax(list);
        Integer[] frequencyList = new Integer[max + 1];
        Arrays.fill(frequencyList, 0);
        for (Integer value : list) {
            frequencyList[value]++;
        }
        for (Integer integer : frequencyList) {
            if (integer > m) {
                return true;
            }
        }
        return false;
    }

    private static int getMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Integer integer : list) {
            if (integer > max) {
                max = integer;
            }
        }
        return max;
    }

    public static void startGame(State state, PlayerA playerA, PlayerB playerB) {
        List<Integer> list = readDataFromCommandLine();

        state.initializeState(list.get(0), list.get(1), list.get(2), playerA, playerB);

        String typePlayerB = getTypePlayerB();

        playerA.setBallList(playerA.getKBallsByBotPlayer(state));

        switch (typePlayerB.toLowerCase()) {
            case "bot":
                playerB.setListFromBotPlayer(state);
                break;
            case "human":
                playerB.setListFromHumanPlayer(state);
                break;
            default:
                throw new IllegalArgumentException();
        }

        System.out.println("A: " + playerA.getBallList());

        state.getWinnerInTheCurrentGame();
    }

    private static String getTypePlayerB() {
        Scanner in = new Scanner(System.in);
        System.out.println("What you want to be player B, human or bot? ");
        return in.next();
    }

    private static List<Integer> readDataFromCommandLine() {
        Scanner in = new Scanner(System.in);
        List<Integer> varList = new ArrayList<>();
        System.out.print("Give a natural value for n: ");
        varList.add(in.nextInt());

        System.out.print("Give a natural value for m: ");
        varList.add(in.nextInt());

        System.out.print("Give a natural value for k: ");
        varList.add(in.nextInt());

        for (int val : varList) {
            if (val < 0) {
                throw new IllegalArgumentException();
            }
        }

        return varList;
    }
}

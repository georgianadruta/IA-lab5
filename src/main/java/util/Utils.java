package util;

import java.util.*;

public class Utils {
    public static List<Integer> readListFromHuman(int k, int n, int m) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();

        while (!Utils.isValidColorList(list, k, n, m)) {
            for (int i = 0; i < k; i++) {
                System.out.print("Give a natural value < n: ");
                list.add(in.nextInt());
            }
        }

        return list;
    }

    private static boolean isValidColorList(List<Integer> list, int k, int n, int m) {
        Integer[] frequencyList = new Integer[list.size()];
        Arrays.fill(frequencyList, 0);
        for (Integer value : list) {
            frequencyList[value]++;
        }

        if (list.size() != k) {
            return false;
        }
        for (Integer integer : frequencyList) {
            if (integer > m) {
                return false;
            }
            // verificat cand avem nr mai mari egale ca n
        }
        return true;
    }
}

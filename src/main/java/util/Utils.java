package util;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static Integer[] getFrequencyArray(List<Integer> list, int n){
        Integer[] frequencyList = new Integer[n];
        Arrays.fill(frequencyList, 0);
        for (Integer value : list) {
            frequencyList[value]++;
        }

        return frequencyList;
    }
}

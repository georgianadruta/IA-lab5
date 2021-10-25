package players;

import state.State;
import util.Utils;

public class PlayerA extends Player {

    public int getNumberOfCommonBalls(State state) {
        Integer[] frequencyListA = Utils.getFrequencyArray(state.getListA(), state.getN());
        Integer[] frequencyListB = Utils.getFrequencyArray(state.getListB(), state.getN());

        int number = 0;
        for (int i = 0; i < frequencyListA.length; i++) {
            number += Math.min(frequencyListA[i], frequencyListB[i]);
        }

        return number;
    }
}

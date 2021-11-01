package players;

import state.State;

import java.util.List;

public class PlayerA extends Player {

    public int getNumberOfCommonBallsBetweenAAndB(State state) {
        List<Integer> listA = state.getListA();
        List<Integer> listB = state.getListB();
        int number = 0;
        for (int i = 0; i < listA.size(); i++)
            if (listA.get(i).equals(listB.get(i))) {
                number++;
            }
        return number;
    }

    public int getNumberOfCommonBallsBetweenAAndAList(State state) {
        List<Integer> listA = state.getListA();
        List<Integer> listB = this.getChosenBalls(state);
        int number = 0;
        for (int i = 0; i < listA.size(); i++)
            if (listA.get(i).equals(listB.get(i))) {
                number++;
            }
        return number;
    }

    public int getNumberOfCommonBallsBetweenAAndAListFromHuman(State state, List<Integer> list) {
        List<Integer> listA = state.getListA();
        int number = 0;
        for (int i = 0; i < listA.size(); i++)
            if (listA.get(i).equals(list.get(i))) {
                number++;
            }
        return number;
    }
}

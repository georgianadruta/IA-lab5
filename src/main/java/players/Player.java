package players;

import state.State;

import java.util.*;

public abstract class Player {

    public List<Integer> getKBallsByBotPlayer(State state) {
        Random rand = new Random();
        List<Integer> copyBallsList = new ArrayList<>(state.getBallsList());
        List<Integer> newList = new LinkedList<>();
        for (int i = 0; i < state.getK(); i++) {
            if (!copyBallsList.isEmpty()) {
                int x = rand.nextInt(copyBallsList.size());
                newList.add(copyBallsList.get(x));
                copyBallsList.remove(x);
            }
        }
        return newList;
    }
}

package players;

import lombok.Data;
import lombok.EqualsAndHashCode;
import state.State;

import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PlayerA extends Player {
    private List<Integer> ballList = new LinkedList<>();

    public int getNumberOfCommonBallsBetweenPlayerAAndPlayerB(State state) {
        List<Integer> listB = state.getPlayerB().getBallList();
        int number = 0;
        for (int i = 0; i < this.ballList.size(); i++)
            if (this.ballList.get(i).equals(listB.get(i))) {
                number++;
            }
        System.out.println("Number of matches: " + number);
        return number;
    }
}

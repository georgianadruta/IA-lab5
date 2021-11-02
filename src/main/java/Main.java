import players.PlayerA;
import players.PlayerB;
import state.State;
import util.Utils;

public class Main {
    public static void main(String[] args) {
        State state = new State();
        PlayerA playerA = new PlayerA();
        PlayerB playerB = new PlayerB();
        try {
            Utils.startGame(state, playerA, playerB);
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid data.");
        }
    }
}

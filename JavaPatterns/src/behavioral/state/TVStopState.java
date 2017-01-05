package behavioral.state;

/**
 * Created by Marina on 03.01.2017.
 */
public class TVStopState implements  State{

    @Override
    public void doAction() {
        System.out.println("TV is turned OFF");
    }
}

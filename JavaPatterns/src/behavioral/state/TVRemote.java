package behavioral.state;

/**
 * Created by Marina on 03.01.2017.
 */
public class TVRemote {
    public static void main(String[] args) {
        TVContext context = new TVContext();
        State tvStartState = new TVStartState();
        State tvStopState = new TVStopState();

        context.setTvState(tvStartState);
        context.doAction();

        context.setTvState(tvStopState);
        context.doAction();

    }
}

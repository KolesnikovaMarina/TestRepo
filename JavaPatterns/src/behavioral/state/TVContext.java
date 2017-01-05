package behavioral.state;

/**
 * Created by Marina on 03.01.2017.
 */
public class TVContext implements State {
    private State tvState;

    @Override
    public void doAction() {
        this.tvState.doAction();
    }

    public State getTvState() {
        return tvState;
    }

    public void setTvState(State tvState) {
        this.tvState = tvState;
    }
}

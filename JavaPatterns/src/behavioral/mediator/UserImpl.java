package behavioral.mediator;

/**
 * Created by Marina on 02.01.2017.
 */
public class UserImpl extends User {

    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println(this.name+": Sending Message=" + msg);
        mediator.sendMessage(msg,this);
    }

    @Override
    public void receiveMessage(String msg) {
        System.out.println(this.name+": Received Message:" + msg);
    }
}

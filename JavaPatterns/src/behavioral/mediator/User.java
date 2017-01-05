package behavioral.mediator;

/**
 * Created by Marina on 02.01.2017.
 */
public abstract class User {
    protected  ChatMediator mediator;
    protected  String name;

    public User(ChatMediator med, String name){
        this.mediator = med;
        this.name = name;
    }

    public abstract void sendMessage(String message);
    public abstract void receiveMessage(String message);
}

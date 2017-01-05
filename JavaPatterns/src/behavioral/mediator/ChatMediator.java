package behavioral.mediator;

/**
 * Created by Marina on 02.01.2017.
 */
public interface ChatMediator {
    public void sendMessage(String message,User user);

    public  void addUser(User user);
}

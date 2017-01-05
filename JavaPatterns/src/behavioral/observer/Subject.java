package behavioral.observer;

/**
 * Created by Marina on 02.01.2017.
 */
public interface Subject {
    public void register(Observer obj);
    public void unregister(Observer obj);

    public void notifyObservers();

    public Object getUpdate(Observer obj);

}

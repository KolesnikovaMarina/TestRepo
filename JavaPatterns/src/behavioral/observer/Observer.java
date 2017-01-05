package behavioral.observer;

/**
 * Created by Marina on 03.01.2017.
 */
public interface Observer {
    public void update();

    public void setSubject(Subject subj);
}

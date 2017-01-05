package behavioral.observer;

/**
 * Created by Marina on 03.01.2017.
 */
public class ObserverPatternTest {
    public static void main(String[] args) {
        MyTopic topic = new MyTopic();
        Observer obj = new MyTopicSubscriber("Tamara");
        Observer obj1 = new MyTopicSubscriber("Vito");
        Observer obj2 = new MyTopicSubscriber("Marina");

        topic.register(obj);
        topic.register(obj1);
        topic.register(obj2);

        obj.setSubject(topic);
        obj1.setSubject(topic);
        obj2.setSubject(topic);

        topic.postMessage("Hello guys");
        topic.unregister(obj);

        obj1.update();
        obj2.update();
        topic.postMessage("Why do you unregister Tamara?");

    }
}

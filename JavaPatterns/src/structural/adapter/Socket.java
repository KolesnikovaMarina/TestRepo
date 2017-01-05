package structural.adapter;

/**
 * Created by Marina on 29.12.2016.
 */
public class Socket {
    public Volt getVolt(){
        return new Volt(120);
    }

}

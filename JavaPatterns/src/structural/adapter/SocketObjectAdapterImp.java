package structural.adapter;

/**
 * Created by Marina on 29.12.2016.
 */
public class SocketObjectAdapterImp implements SocketAdapter {
    private Socket sock =new Socket();
    @Override
    public Volt get120Volt() {
        return get3Volt();
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(sock.getVolt(),10);
    }

    @Override
    public Volt get3Volt() {
        return convertVolt(sock.getVolt(),60);
    }

    private Volt convertVolt(Volt v,int i){
        return new Volt(v.getVolts()/i);
    }
}

package structural.adapter;

/**
 * Created by Marina on 29.12.2016.
 */
public class SocketClassAdapterImpl extends Socket  implements SocketAdapter {

    @Override
    public Volt get120Volt() {
        return get3Volt();
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(getVolt(),10);
    }

    @Override
    public Volt get3Volt() {
        return convertVolt(getVolt(),60);
    }

    private Volt convertVolt(Volt v,int i){
        return new Volt(v.getVolts()/i);
    }
}

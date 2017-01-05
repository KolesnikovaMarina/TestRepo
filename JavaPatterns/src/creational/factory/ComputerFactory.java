package creational.factory;

/**
 * Created by Marina on 29.12.2016.
 */
public class ComputerFactory {
    public static Computer getComputer(String type, String ram, String hdd, String cpu){
        if("PC".equalsIgnoreCase(type)) return new PC(ram,hdd,cpu);
        else if("Server".equalsIgnoreCase(type)) return new Server(ram,hdd,cpu);
        return null;
    }

}

package creational.factory;

/**
 * Created by Marina on 29.12.2016.
 */
public class ComputerFactory1 {
    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}

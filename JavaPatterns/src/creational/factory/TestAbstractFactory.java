package creational.factory;

/**
 * Created by Marina on 29.12.2016.
 */
public class TestAbstractFactory {
    public static void main(String[] args){
        ComputerAbstractFactory pcFactory = new PCFactory("2 GB","500 GB","2.4 Gz");
        ComputerAbstractFactory serverFactory = new PCFactory("2 GB","500 GB","2.4 Gz");
        Computer pc = ComputerFactory1.getComputer(pcFactory);
        Computer server = ComputerFactory1.getComputer(serverFactory);

        System.out.println("Factory PC config:" + pc);
        System.out.println("Factory Server config:" + server);
    }
}


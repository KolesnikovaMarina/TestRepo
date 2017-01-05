package creational.factory;

/**
 * Created by Marina on 29.12.2016.
 */
public class TestFactory {
    public static void main(String[] args){
        Computer pc = ComputerFactory.getComputer("pc", "2 GB","500 GB","2.4 GHz");
        Computer server = ComputerFactory.getComputer("Server", "16 GB","1 GB","2.9 GHz");
        System.out.println("Factory PC config" + pc);
        System.out.println("Factory Server config" + server);
    }
}


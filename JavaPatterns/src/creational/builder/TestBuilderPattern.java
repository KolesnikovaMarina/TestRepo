package creational.builder;

/**
 * Created by Marina on 29.12.2016.
 */
public class TestBuilderPattern {
    public static void main(String[] args){
        //using creational.builder to get the object is a single line of code and without any inconsistent state or arguments management issues
        Computer comp = new Computer.ComputerBuilder("500 GB","2 GB").setBluetoothEnabled(true).setGrathicsCardEnabled(true).build();

    }

}

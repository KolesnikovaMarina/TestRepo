package structural.decorator;

/**
 * Created by Marina on 02.01.2017.
 */
public class BasicCar implements Car {
    @Override
    public void assembly() {
        System.out.println("Assemble basic car");
    }
}

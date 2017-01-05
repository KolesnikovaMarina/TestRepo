package structural.decorator;

/**
 * Created by Marina on 02.01.2017.
 */
public class CarDecorator implements Car {
    protected Car car;
    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assembly() {
        this.car.assembly();
    }
}

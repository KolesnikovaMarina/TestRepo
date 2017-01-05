package structural.decorator;

/**
 * Created by Marina on 02.01.2017.
 */
public class DecoratorTest {
    public static void main(String[] args) {
        BasicCar car = new BasicCar();
        car.assembly();
        CarDecorator lcur = new LuxuryCar(car);
        lcur.assembly();
        CarDecorator slcur = new SportCar(lcur);
        slcur.assembly();
    }
}

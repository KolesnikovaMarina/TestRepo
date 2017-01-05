package structural.decorator;

/**
 * Created by Marina on 02.01.2017.
 */
public class SportCar extends CarDecorator {
    public SportCar(Car car) {
        super(car);
    }
    public void assembly(){
        super.assembly();
        System.out.printf("Adding features of Sport car");
    }
}

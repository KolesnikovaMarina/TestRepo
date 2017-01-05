package structural.decorator;

/**
 * Created by Marina on 02.01.2017.
 */
public class LuxuryCar extends CarDecorator{
    public LuxuryCar(Car car) {
        super(car);
    }
    public void assembly(){
        super.assembly();
        System.out.println("Adding features of Luxury Car");
    }

}

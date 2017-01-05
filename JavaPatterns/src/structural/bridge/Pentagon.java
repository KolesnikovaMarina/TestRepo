package structural.bridge;

/**
 * Created by Marina on 02.01.2017.
 */
public class Pentagon extends Shape {
    public Pentagon(Color c){
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.println("Triangle filled with color ");
        color.applyColor();
    }
}

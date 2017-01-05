package structural.composite;

/**
 * Created by Marina on 29.12.2016.
 */
public class Circle implements Shape {
    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Circle with color" + fillColor);
    }
}

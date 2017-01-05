package structural.bridge;

/**
 * Created by Marina on 02.01.2017.
 */
public abstract class Shape {
    protected  Color color;
    public Shape(Color c){
        this.color = c;
    }
    abstract  public void applyColor();
}

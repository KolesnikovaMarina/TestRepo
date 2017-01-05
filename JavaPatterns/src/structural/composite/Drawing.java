package structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marina on 29.12.2016.
 */
public class Drawing implements Shape {

    private List<Shape> shapes = new ArrayList<Shape>();
    @Override
    public void draw(String fillColor) {
        for(Shape sh : shapes){
            sh.draw(fillColor);
        }
    }
    public void addShape(Shape sh){
        shapes.add(sh);
    }
    public  void removeShape(Shape sh){
        shapes.remove(sh);
    }
    public void clear(){
        shapes.clear();
    }
}

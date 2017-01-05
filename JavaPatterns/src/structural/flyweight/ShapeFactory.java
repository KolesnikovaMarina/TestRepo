package structural.flyweight;

import java.util.HashMap;

/**
 * Created by Marina on 01.01.2017.
 */
public class ShapeFactory {
    private static final HashMap<ShapeType,Shape> shapes = new HashMap<ShapeType,Shape>();

    public static Shape getShape(ShapeType type){
        Shape shapeImpl = shapes.get(type);
        if(shapeImpl == null){
            switch (type){
               case LINE : shapeImpl = new Line();
                   break;
               case OVAL_FILL : shapeImpl = new Oval(true);
                   break;
               case OVAL_NOFILL : shapeImpl = new Oval(false);
                   break;
            }
            shapes.put(type,shapeImpl);
        }
        return shapeImpl;
    }
    public static enum ShapeType{
        OVAL_FILL,OVAL_NOFILL,LINE;
    }
}

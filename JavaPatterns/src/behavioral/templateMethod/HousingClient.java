package behavioral.templateMethod;

/**
 * Created by Marina on 02.01.2017.
 */
public class HousingClient {
    public static void main(String[] args) {
        HouseTemplate woodenHouse = new WoodenHouse();
        HouseTemplate glassHouse = new GlassHouse();
        woodenHouse.buildHouse();
        System.out.println("*************");
        glassHouse.buildHouse();
    }
}

package behavioral.templateMethod;

/**
 * Created by Marina on 02.01.2017.
 */
public abstract class HouseTemplate {
    public final void buildHouse(){
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is built.");
    }
    //default implementation
    private void buildWindows() {
        System.out.println("Building Glass Windows");
    }
    //methods to be implemented by subclasses
    public abstract void buildWalls();
    public abstract void buildPillars();
    private void buildFoundation() {
        System.out.println("Building foundation with cement,iron rods and sand");
    }

}

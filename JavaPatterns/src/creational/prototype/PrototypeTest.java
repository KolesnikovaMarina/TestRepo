package creational.prototype;

/**
 * Created by Marina on 29.12.2016.
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException{
        Employees emp1 = new Employees();
        emp1.loadDate();
        Employees emp2 = (Employees) emp1.clone();

    }
}

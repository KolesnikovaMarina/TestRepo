package creational.factory;

/**
 * Created by Marina on 29.12.2016.
 */
public abstract class Computer {
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    @Override
    public String toString() {
        return  "RAM = " + getRAM() + ", HDD = " + getHDD() + ", CPU = " + getCPU();
    }
}




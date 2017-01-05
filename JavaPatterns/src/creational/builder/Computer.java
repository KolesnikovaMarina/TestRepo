package creational.builder;

/**
 * Created by Marina on 29.12.2016.
 */
public class Computer {
    //required parameters
    private String HDD;
    private String RAM;

    //optional parameters
    private boolean isGrathicsCardEnabled;
    private boolean isBluetoothEnabled;


    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isGrathicsCardEnabled() {
        return isGrathicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }
    private Computer(ComputerBuilder builder){
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isGrathicsCardEnabled = builder.isGrathicsCardEnabled;
    }

    public  static class ComputerBuilder {
        //required parameters
        private String HDD;
        private String RAM;

        //optional parameters
        private boolean isGrathicsCardEnabled;
        private boolean isBluetoothEnabled;
        public ComputerBuilder(String hdd,String ram){
            this.HDD = hdd;
            this.RAM = ram;
        }

        public ComputerBuilder setGrathicsCardEnabled(boolean isGrathicsCardEnabled){
            this.isGrathicsCardEnabled = isGrathicsCardEnabled;
            return this;
        }
        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled){
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }
        public Computer build(){
            return new Computer(this);
        }
    }
}

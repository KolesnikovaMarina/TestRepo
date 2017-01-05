package behavioral.command;

/**
 * Created by Marina on 03.01.2017.
 */
public class WindowsFileReceiver implements FileSystemReceiver {
    @Override
    public void openFile() {
        System.out.println("Opening file in Windows OS");
    }
    @Override
    public void writeFile() {
        System.out.println("Writing file in Windows OS");
    }
    @Override
    public void closeFile() {
        System.out.println("Closing file in Windows OS");
    }
}

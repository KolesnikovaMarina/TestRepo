package structural.proxy;

/**
 * Created by Marina on 29.12.2016.
 */
public class ProxyPatternTest {
    public static void main(String[] args){
        CommandExecutor executor = new CommandExecutorProxy("Pankaj","1234");
        try{
            //executor.executeCommand("ls -ltr");
           //executor.executeCommand("rm -rf abc.pdf");
        }catch (Exception e){
            System.out.println("Exception Message::" + e.getMessage());
        }
    }
}

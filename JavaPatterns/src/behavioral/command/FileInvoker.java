package behavioral.command;

/**
 * Created by Marina on 03.01.2017.
 */
public class FileInvoker {
    public Command command;
    public FileInvoker(Command c){
        this.command=c;
    }
    public void execute(){
        this.command.execute();
    }
}

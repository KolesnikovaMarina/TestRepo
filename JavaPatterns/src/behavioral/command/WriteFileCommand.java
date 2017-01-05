package behavioral.command;

/**
 * Created by Marina on 03.01.2017.
 */
public class WriteFileCommand implements Command {
    private FileSystemReceiver fileSystem;

    public WriteFileCommand(FileSystemReceiver fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute() {
        fileSystem.writeFile();
    }
}

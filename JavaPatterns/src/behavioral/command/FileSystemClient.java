package behavioral.command;

/**
 * Created by Marina on 03.01.2017.
 */
public class FileSystemClient {
    public static void main(String[] args) {
        FileSystemReceiver fileSystem = FileSystemReceiverUtil.getUnderlyingFileSystem();
        FileInvoker invoker = new FileInvoker(new OpenFileCommand(fileSystem));
        invoker.execute();

        invoker = new FileInvoker(new WriteFileCommand(fileSystem));
        invoker.execute();

        invoker = new FileInvoker(new CloseFileCommand(fileSystem));
        invoker.execute();

    }
}

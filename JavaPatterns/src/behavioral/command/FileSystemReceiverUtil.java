package behavioral.command;

/**
 * Created by Marina on 03.01.2017.
 */
public class FileSystemReceiverUtil {
    public static FileSystemReceiver getUnderlyingFileSystem(){
        String osName = System.getProperty("os.name");
        System.out.println("Underlying OS is:"+osName);
        if(osName.contains("Windows")){
            return new WindowsFileReceiver();
        }else{
            return new UnixFileSystemReceiver();
        }
    }
}

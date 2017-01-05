package structural.proxy;

import java.io.IOException;

/**
 * Created by Marina on 29.12.2016.
 */
public interface CommandExecutor {
    public  void executeCommand(String cmd) throws IOException;
}

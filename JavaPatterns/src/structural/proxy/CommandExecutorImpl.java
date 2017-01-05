package structural.proxy;

import java.io.IOException;

/**
 * Created by Marina on 29.12.2016.
 */
public class CommandExecutorImpl implements CommandExecutor {
    @Override
    public void executeCommand(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);
        System.out.println("'"+cmd+"' command executed");
    }

}

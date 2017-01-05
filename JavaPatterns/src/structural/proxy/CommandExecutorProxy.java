package structural.proxy;

import java.io.IOException;

/**
 * Created by Marina on 29.12.2016.
 */
public class CommandExecutorProxy implements CommandExecutor {
    private boolean isAdmin;
    private CommandExecutor executor;
    public CommandExecutorProxy(String user, String pwd){
        if("Pankaj".equals(user)&&"1234".equals(pwd)) isAdmin = true;
         executor = new CommandExecutorImpl();
    }

    @Override
    public void executeCommand(String cmd) throws IOException {
        if(isAdmin){
            executor.executeCommand(cmd);
        }else{
            if(cmd.trim().startsWith("rm")){
                throw new IOException("rm command is not allowed for non-admin users.");
            }else{
                executor.executeCommand(cmd);
            }
        }
    }

}

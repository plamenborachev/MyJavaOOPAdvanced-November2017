package p01Logger;

import p01Logger.interfaces.Command;
import p01Logger.interfaces.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}

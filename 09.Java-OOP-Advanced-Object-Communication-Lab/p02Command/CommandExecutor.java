package p02Command;

import p02Command.interfaces.Command;
import p02Command.interfaces.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}

package p04Observer.implementations;

import p04Observer.interfaces.Command;
import p04Observer.interfaces.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}

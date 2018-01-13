package p03Mediator.implementations;

import p03Mediator.interfaces.Command;
import p03Mediator.interfaces.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}

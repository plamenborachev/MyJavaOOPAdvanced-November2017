package p02Command;

import p02Command.abstractClasses.AbstractLogger;

public class TargetLogger extends AbstractLogger {
    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.TARGET){
            System.out.println(type.name() + ": " + message);
        }

        super.passToSuccessor(type, message);
    }
}

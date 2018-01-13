package p02Command.loggers;

import p02Command.LogType;
import p02Command.abstractClasses.AbstractLogger;

public class ErrorLogger extends AbstractLogger {
    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ERROR){
            System.out.println(type.name() + ": " + message);
        }

        super.passToSuccessor(type, message);
    }
}

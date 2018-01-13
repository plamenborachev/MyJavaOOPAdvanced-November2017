package p01Logger.loggers;

import p01Logger.LogType;
import p01Logger.abstractClasses.AbstractLogger;

public class ErrorLogger extends AbstractLogger {
    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ERROR){
            System.out.println(type.name() + ": " + message);
        }

        super.passToSuccessor(type, message);
    }
}

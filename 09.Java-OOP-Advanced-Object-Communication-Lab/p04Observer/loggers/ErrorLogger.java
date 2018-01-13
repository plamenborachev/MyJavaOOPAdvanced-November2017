package p04Observer.loggers;

import p04Observer.LogType;
import p04Observer.abstractClasses.AbstractLogger;

public class ErrorLogger extends AbstractLogger {
    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ERROR){
            System.out.println(type.name() + ": " + message);
        }

        super.passToSuccessor(type, message);
    }
}

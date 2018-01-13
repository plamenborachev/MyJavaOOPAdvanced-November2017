package p01Logger.loggers;

import p01Logger.LogType;
import p01Logger.abstractClasses.AbstractLogger;

public class EventLogger extends AbstractLogger {
    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.EVENT){
            System.out.println(type.name() + ": " + message);
        }

        super.passToSuccessor(type, message);
    }
}

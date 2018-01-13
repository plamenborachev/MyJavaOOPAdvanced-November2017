package p03Mediator.loggers;

import p03Mediator.LogType;
import p03Mediator.abstractClasses.AbstractLogger;

public class EventLogger extends AbstractLogger {
    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.EVENT){
            System.out.println(type.name() + ": " + message);
        }

        super.passToSuccessor(type, message);
    }
}

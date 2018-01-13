package p03Mediator.implementations;

import p03Mediator.LogType;
import p03Mediator.abstractClasses.AbstractLogger;

public class TargetLogger extends AbstractLogger {
    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.TARGET){
            System.out.println(type.name() + ": " + message);
        }

        super.passToSuccessor(type, message);
    }
}

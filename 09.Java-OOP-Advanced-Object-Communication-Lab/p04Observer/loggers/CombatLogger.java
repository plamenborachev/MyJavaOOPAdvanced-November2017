package p04Observer.loggers;

import p04Observer.LogType;
import p04Observer.abstractClasses.AbstractLogger;

public class CombatLogger extends AbstractLogger {

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ATTACK || type == LogType.MAGIC){
            System.out.println(type.name() + ": " + message);
        }

        super.passToSuccessor(type, message);
    }
}

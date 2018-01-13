package p01Logger.loggers;

import p01Logger.LogType;
import p01Logger.abstractClasses.AbstractLogger;

public class CombatLogger extends AbstractLogger {

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ATTACK || type == LogType.MAGIC){
            System.out.println(type.name() + ": " + message);
        }

        super.passToSuccessor(type, message);
    }
}

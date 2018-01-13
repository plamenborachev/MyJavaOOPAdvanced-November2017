package p02Command.loggers;

import p02Command.LogType;
import p02Command.abstractClasses.AbstractLogger;

public class CombatLogger extends AbstractLogger {

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ATTACK || type == LogType.MAGIC){
            System.out.println(type.name() + ": " + message);
        }

        super.passToSuccessor(type, message);
    }
}

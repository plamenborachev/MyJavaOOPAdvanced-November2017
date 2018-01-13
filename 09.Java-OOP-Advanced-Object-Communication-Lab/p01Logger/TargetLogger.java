package p01Logger;

import p01Logger.abstractClasses.AbstractLogger;

public class TargetLogger extends AbstractLogger {
    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.TARGET){
            System.out.println(type.name() + ": " + message);
        }

        super.passToSuccessor(type, message);
    }
}

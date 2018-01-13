package p01Logger.abstractClasses;

import p01Logger.LogType;
import p01Logger.interfaces.Handler;

public abstract class AbstractLogger implements Handler {

    private Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected void passToSuccessor(LogType type, String message){
        if (this.successor != null){
            this.successor.handle(type, message);
        }
    }

    public abstract void handle(LogType type, String message);
}

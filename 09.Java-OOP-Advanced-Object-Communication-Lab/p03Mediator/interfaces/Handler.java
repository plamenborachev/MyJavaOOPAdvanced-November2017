package p03Mediator.interfaces;

import p03Mediator.LogType;

public interface Handler {

    void handle(LogType type, String message);

    void setSuccessor(Handler handler);
}

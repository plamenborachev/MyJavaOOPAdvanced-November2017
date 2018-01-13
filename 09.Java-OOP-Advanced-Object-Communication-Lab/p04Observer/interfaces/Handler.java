package p04Observer.interfaces;

import p04Observer.LogType;

public interface Handler {

    void handle(LogType type, String message);

    void setSuccessor(Handler handler);
}

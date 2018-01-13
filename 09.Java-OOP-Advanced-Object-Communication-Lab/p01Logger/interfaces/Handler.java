package p01Logger.interfaces;

import p01Logger.LogType;

public interface Handler {

    void handle(LogType type, String message);

    void setSuccessor(Handler handler);
}

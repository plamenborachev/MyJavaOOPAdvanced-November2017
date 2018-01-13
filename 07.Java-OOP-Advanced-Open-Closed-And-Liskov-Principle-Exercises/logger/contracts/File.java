package logger.contracts;

public interface File {
    void write(String formattedMessage);

    long getSize();
}

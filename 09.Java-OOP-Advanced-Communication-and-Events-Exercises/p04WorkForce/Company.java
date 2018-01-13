package p04WorkForce;

public interface Company {
    void attach(Observer observer);

    void clearJobsDone();

    void notifyAllObservers();

    String status();
}

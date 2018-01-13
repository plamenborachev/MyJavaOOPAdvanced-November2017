package p04Observer.interfaces;


public interface Subject {

    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers();
}

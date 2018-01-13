package collection;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public interface Register<T> {
    void enqueueEmergency(T emergency);

    T dequeueEmergency();

    T peekEmergency();

    Boolean isEmpty();

    int size();

    T[] getEmergencyQueue();
}

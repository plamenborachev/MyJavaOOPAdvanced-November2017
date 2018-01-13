package collection;


public class EmergencyRegister<T> implements Register<T> {

    private static final Integer INITIAL_SIZE = 16;
    private T[] emergencyQueue;
    private Integer currentSize;
    private Integer nextIndex;

    public EmergencyRegister() {
        this.emergencyQueue = (T[]) new Object[INITIAL_SIZE];
        this.currentSize = 0;
        this.nextIndex = 0;
    }

    private void incrementNextIndex() {
        this.nextIndex++;
    }

    private void decrementNextIndex() {
        this.nextIndex--;
    }

    private void incrementCurrentSize() {
        this.currentSize++;
    }

    private void decrementCurrentSize() {
        this.currentSize--;
    }

    private void checkIfResizeNeeded() {
        if (this.currentSize == this.emergencyQueue.length) {
            this.resize();
        }
    }

    private void resize() {
        T[] newArray = (T[]) new Object[2 * this.currentSize];

        System.arraycopy(this.emergencyQueue, 0, newArray, 0, this.currentSize);

        this.emergencyQueue = newArray;
    }

    public void enqueueEmergency(T emergency) {
        this.checkIfResizeNeeded();

        this.emergencyQueue[this.nextIndex] = emergency;
        this.incrementNextIndex();

        this.incrementCurrentSize();
    }

    public T dequeueEmergency() {
        T removedElement = this.emergencyQueue[0];

        System.arraycopy(this.emergencyQueue, 1, this.emergencyQueue, 0, this.currentSize - 1);

        this.decrementNextIndex();
        this.decrementCurrentSize();

        return removedElement;
    }

    public T peekEmergency() {
        return this.emergencyQueue[0];
    }

    public Boolean isEmpty() {
        return this.currentSize == 0;
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public T[] getEmergencyQueue() {
        return emergencyQueue;
    }
}

package p11Threeuple;

public class Tuple<T, E, P> {
    private T item1;
    private E item2;
    private P item3;

    public Tuple(T item1, E item2, P item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return this.item1 + " -> " + this.item2 + " -> " + this.item3;
    }
}

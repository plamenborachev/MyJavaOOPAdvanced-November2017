package p07CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public List<T> getElements() {
        return Collections.unmodifiableList(elements);
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void remove(int index) {
        this.elements.remove(index);
    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public void swap(int index1, int index2) {
        T temp = this.elements.get(index1);
        this.elements.set(index1, this.elements.get(index2));
        this.elements.set(index2, temp);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T el : this.elements) {
            if (el.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        T maxElement = this.elements.get(0);
        for (int i = 1; i < this.elements.size(); i++) {
            if (this.elements.get(i).compareTo(maxElement) > 0) {
                maxElement = this.elements.get(i);
            }
        }
        return maxElement;
    }

    public T getMin() {
        T minElement = this.elements.get(0);
        for (int i = 1; i < this.elements.size(); i++) {
            if (this.elements.get(i).compareTo(minElement) < 0) {
                minElement = this.elements.get(i);
            }
        }
        return minElement;
    }

}

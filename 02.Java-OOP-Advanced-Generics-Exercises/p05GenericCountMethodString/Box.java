package p05GenericCountMethodString;

import java.util.List;

public class Box<T> {
    private T t;

    public Box(T t) {
        this.t = t;
    }

    public static <T> void swap(List<T> list, int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public static <T extends Comparable<T>> int countGreaterElements(List<T> list, T element){
        int counter = 0;
        for (T item : list) {
            if (item.compareTo(element) > 0){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", t.getClass(), t).replace("class ", "");
    }
}

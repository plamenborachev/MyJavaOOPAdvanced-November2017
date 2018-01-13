package p02GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator<T> {
    public static <T> T[] create(int length, T item){
        T[] arr = (T[]) new Object[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;
        }
        return arr;
    }

    public static <T> T[] create(Class<T> cl, int length, T item){
        T[] arr = (T[]) Array.newInstance(cl, length);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;
        }
        return arr;
    }
}

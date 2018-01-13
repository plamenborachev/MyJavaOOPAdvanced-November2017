package p01ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator<T> implements Iterable<T> {
    private List<T> list;
    private int index;

    public ListyIterator(T... list) {
        this.index = 0;
        this.setList(list);
    }

    private void setList(T... list) {
        this.list = Arrays.asList(list);
    }

    public boolean move(){
        if(this.hasNext()){
            this.iterator().next();
            return true;
        }
        return false;
    }

    public void print(){
        if (this.list.isEmpty()){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(list.get(this.index));
    }

    public boolean hasNext(){
        return this.index < this.list.size() - 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIteratorInner();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        while (this.iterator().hasNext()){
            action.accept(this.iterator().next());
        }
    }

    private final class ListIteratorInner implements Iterator<T>{
        @Override
        public boolean hasNext() {
            return index < list.size();
        }

        @Override
        public T next() {
            return list.get(index++);
        }
    }
}

package p03StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack<T extends Integer> implements Iterable<Integer> {
    private List<Integer> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public void push(int element){
        this.stack.add(element);
    }

    public int pop(){
        if (this.stack.isEmpty()){
            throw new IndexOutOfBoundsException("No elements");
        }
        int element = this.stack.get(stack.size() - 1);
        this.stack.remove(stack.size() - 1);
        return element;
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = this.stack.size() - 1; j >= 0 ; j--) {
                sb.append(this.stack.get(j));
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new stackIterator();
    }

    private final class stackIterator implements Iterator<Integer>{
        private int index;

        public stackIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < stack.size();
        }

        @Override
        public Integer next() {
            return stack.get(index++);
        }
    }
}

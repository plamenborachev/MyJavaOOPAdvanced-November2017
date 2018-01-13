package p04Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake<T extends Integer> implements Iterable<Integer> {
    private List<Integer> lake;

    public Lake(List<Integer> lake) {
        this.lake = lake;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    public List<Integer> jump(){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < this.lake.size(); i += 2) {
            result.add(lake.get(i));
        }
        for (int i = 1; i < this.lake.size(); i += 2) {
            result.add(lake.get(i));
        }
        return result;
    }

    private final class Frog implements Iterator<Integer>{
        private int index;

        public Frog() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < lake.size();
        }

        @Override
        public Integer next() {
            return lake.get(this.index++);
        }
    }
}

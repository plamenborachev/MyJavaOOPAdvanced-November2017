package p09CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class MyListImpl<T> implements MyList<T> {
    private List<T> list;

    public MyListImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public Integer add(T element) {
        this.list.add(0, element);
        return 0;
    }

    @Override
    public Integer Used() {
        return this.list.size();
    }

    @Override
    public T Remove() {
        return this.list.remove(0);
    }
}

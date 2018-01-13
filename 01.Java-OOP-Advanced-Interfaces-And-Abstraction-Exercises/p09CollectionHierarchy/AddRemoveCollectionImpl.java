package p09CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddRemoveCollectionImpl<T> implements AddRemoveCollection<T> {
    private List<T> list;

    public AddRemoveCollectionImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public Integer add(T element) {
        this.list.add(0, element);
        return 0;
    }

    @Override
    public T Remove() {
        return this.list.remove(this.list.size() - 1);
    }
}

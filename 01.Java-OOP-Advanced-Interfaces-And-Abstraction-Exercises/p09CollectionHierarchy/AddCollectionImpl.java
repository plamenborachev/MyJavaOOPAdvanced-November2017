package p09CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddCollectionImpl<T> implements AddCollection<T> {
    private List<T> list;

    public AddCollectionImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public Integer add(T element) {
        this.list.add(element);
        return this.list.size() - 1;
    }
}

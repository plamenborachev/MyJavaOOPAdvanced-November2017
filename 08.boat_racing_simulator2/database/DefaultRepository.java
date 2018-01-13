package database;

import contracts.Modelable;
import contracts.Repository;
import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;
import utility.Constants;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultRepository<T extends Modelable> implements Repository<T> {

    private Map<String, T> itemsByModel;

    public DefaultRepository() {
        this.itemsByModel = new LinkedHashMap<>();
    }

    @Override
    public void add(T item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }
        this.itemsByModel.put(item.getModel(), item);
    }

    @Override
    public T getItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model)) {
            throw new NonExistantModelException(Constants.NonExistantModelMessage);
        }
        return this.itemsByModel.get(model);
    }

}

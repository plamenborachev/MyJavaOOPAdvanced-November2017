package contracts;

import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;

public interface Repository<T extends Modelable> {
    
    void add(T item) throws DuplicateModelException;

    T getItem(String model) throws NonExistantModelException;
    
}

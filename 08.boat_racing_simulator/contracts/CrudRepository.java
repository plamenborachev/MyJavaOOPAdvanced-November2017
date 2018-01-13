package contracts;

import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;

public interface CrudRepository<T> {

    void add(T item) throws DuplicateModelException;

    T getByModel(String model) throws NonExistantModelException;
}

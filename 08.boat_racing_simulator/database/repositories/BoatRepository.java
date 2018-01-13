package database.repositories;

import contracts.Boat;
import contracts.CrudRepository;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;
import utility.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatRepository implements CrudRepository<Boat> {
    private Map<String, Boat> boats;

    public BoatRepository() {
        this.boats = new LinkedHashMap<>();
    }

    @Override
    public void add(Boat boat) throws DuplicateModelException {
        if (this.boats.containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }
        this.boats.put(boat.getModel(), boat);
    }

    @Override
    public Boat getByModel(String model) throws NonExistantModelException {
        if (!this.boats.containsKey(model)) {
            throw new NonExistantModelException(Constants.NonExistantModelMessage);
        }

        return this.boats.get(model);
    }

}
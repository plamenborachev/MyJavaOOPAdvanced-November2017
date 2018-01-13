package database.repositories;

import contracts.BoatEngine;
import contracts.CrudRepository;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;
import utility.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatEngineRepository implements CrudRepository<BoatEngine> {
    private Map<String, BoatEngine> boatEngines;

    public BoatEngineRepository() {
        this.boatEngines = new LinkedHashMap<>();
    }

    @Override
    public void add(BoatEngine boat) throws DuplicateModelException {
        if (this.boatEngines.containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }
        this.boatEngines.put(boat.getModel(), boat);
    }

    @Override
    public BoatEngine getByModel(String model) throws NonExistantModelException {
        if (!this.boatEngines.containsKey(model)) {
            throw new NonExistantModelException(Constants.NonExistantModelMessage);
        }

        return this.boatEngines.get(model);
    }

}
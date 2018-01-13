package database;

import contracts.Boat;
import contracts.BoatEngine;
import contracts.CrudRepository;
import contracts.Database;

public class DatabaseImpl implements Database {
    private CrudRepository<Boat> boatRepository;
    private CrudRepository<BoatEngine> boatEngineRepository;

    public DatabaseImpl(CrudRepository<Boat> boatRepository, CrudRepository<BoatEngine> boatEngineRepository) {
        this.boatRepository = boatRepository;
        this.boatEngineRepository = boatEngineRepository;
    }

    @Override
    public CrudRepository<Boat> getBoatRepository() {
        return this.boatRepository;
    }

    @Override
    public CrudRepository<BoatEngine> getBoatEngineRepository() {
        return this.boatEngineRepository;
    }
}

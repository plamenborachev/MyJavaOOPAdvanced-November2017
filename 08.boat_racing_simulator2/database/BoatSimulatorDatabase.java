package database;

import contracts.Repository;
import models.boats.BaseBoat;
import models.boat_engines.BaseBoatEngine;

public class BoatSimulatorDatabase {

    Repository<BaseBoat> boats;
    Repository<BaseBoatEngine> engines;

    public BoatSimulatorDatabase() {
        this.boats = new DefaultRepository<>();
        this.engines = new DefaultRepository<>();
    }

    public Repository<BaseBoat> getBoats() {
        return this.boats;
    }

    public Repository<BaseBoatEngine> getEngines() {
        return this.engines;
    }

}

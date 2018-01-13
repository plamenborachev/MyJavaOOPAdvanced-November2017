package models.boats;

import contracts.BoatRace;
import models.boat_engines.BaseBoatEngine;
import utility.Validator;

public class Yacht extends BaseMotorBoat {

    private int cargo;

    public Yacht(String model, int weight, BaseBoatEngine engine, int cargo) {
        super(model, weight, engine);
        this.setCargo(cargo);
    }

    @Override
    public double calculateRaceSpeed(BoatRace boatRace) {
        return super.getEngine().getOutput() - super.getWeight() - this.cargo + boatRace.getOceanCurrentSpeed() / 2D;
    }

    private void setCargo(int cargo) {
        Validator.validatePropertyPositiveValue(cargo, "Cargo Weight");
        this.cargo = cargo;
    }

}

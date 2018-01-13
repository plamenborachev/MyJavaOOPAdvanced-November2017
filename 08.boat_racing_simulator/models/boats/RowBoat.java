package models.boats;

import contracts.Race;
import utility.Validator;

public final class RowBoat extends BaseBoat {
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    @Override
    public boolean hasEngineInBoat() {
        return false;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (this.oars * 100.0) - super.getWeight() + race.getOceanCurrentSpeed();
    }

    private void setOars(int oars) {
        Validator.ValidatePropertyValue(oars, "Oars");
        this.oars = oars;
    }
}
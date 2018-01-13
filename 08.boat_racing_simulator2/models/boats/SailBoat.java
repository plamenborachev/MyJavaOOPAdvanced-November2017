package models.boats;

import contracts.BoatRace;

public class SailBoat extends BaseBoat {

    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    @Override
    public double calculateRaceSpeed(BoatRace boatRace) {
        return boatRace.getWindSpeed() * this.sailEfficiency / 100D - super.getWeight() + boatRace.getOceanCurrentSpeed() / 2D;
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException("Sail Effectiveness must be between [1...100].");
        }
        this.sailEfficiency = sailEfficiency;
    }

}

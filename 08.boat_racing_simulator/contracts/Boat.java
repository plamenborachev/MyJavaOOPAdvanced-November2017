package contracts;

public interface Boat extends Modelable {

    boolean hasEngineInBoat();

    double calculateRaceSpeed(Race race);
}

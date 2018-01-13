package factories;

import contracts.Race;
import models.RaceImpl;

public final class RaceFactory {

    private RaceFactory() {
    }

    public static Race createRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorBoats) {
        return (Race) new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorBoats);
    }
}

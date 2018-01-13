package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class HealthEmergency extends BaseEmergency {

    private int numberOfCasualties;

    public HealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, int numberOfCasualties) {
        super(description, emergencyLevel, registrationTime);
        this.numberOfCasualties = numberOfCasualties;
    }

    @Override
    public int getAdditionalParam() {
        return this.numberOfCasualties;
    }
}

package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class OrderEmergency extends BaseEmergency {

    private static final String SPECIAL = "Special";
    private String status;

    public OrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, String status) {
        super(description, emergencyLevel, registrationTime);
        this.status = status;
    }

    @Override
    public int getAdditionalParam() {
        return this.status.equals(SPECIAL) ? 1 : 0;
    }
}

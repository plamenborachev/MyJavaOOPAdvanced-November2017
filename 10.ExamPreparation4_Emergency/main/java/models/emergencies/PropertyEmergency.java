package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class PropertyEmergency extends BaseEmergency {

    private int propertyDamage;

    public PropertyEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, int propertyDamage) {
        super(description, emergencyLevel, registrationTime);
        this.propertyDamage = propertyDamage;
    }

    @Override
    public int getAdditionalParam() {
        return this.propertyDamage;
    }
}

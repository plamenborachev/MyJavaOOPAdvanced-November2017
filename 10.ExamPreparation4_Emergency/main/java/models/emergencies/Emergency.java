package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public interface Emergency {
    int getAdditionalParam();

    String getDescription();

    EmergencyLevel getEmergencyLevel();

    RegistrationTime getRegistrationTime();
}

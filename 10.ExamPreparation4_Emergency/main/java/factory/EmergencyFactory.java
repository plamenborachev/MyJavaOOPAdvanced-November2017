package factory;

import enums.EmergencyLevel;
import models.emergencies.Emergency;
import models.emergencies.HealthEmergency;
import models.emergencies.OrderEmergency;
import models.emergencies.PropertyEmergency;
import utils.RegistrationTime;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class EmergencyFactory {
    public static Emergency createPropertyHealthEmergency(String type, String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer damage) {
        switch (type) {
            case "Property":
                return new PropertyEmergency(description, emergencyLevel, registrationTime, damage);
            case "Health":
                return new HealthEmergency(description, emergencyLevel, registrationTime, damage);
            default:
                return null;
        }
    }

    public static Emergency createOrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, String status) {
        return new OrderEmergency(description, emergencyLevel, registrationTime, status);
    }
}

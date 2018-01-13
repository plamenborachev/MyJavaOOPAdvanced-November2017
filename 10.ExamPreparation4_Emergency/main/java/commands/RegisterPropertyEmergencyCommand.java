package commands;


import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import factory.EmergencyFactory;
import models.emergencies.Emergency;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RegisterPropertyEmergencyCommand extends BaseCommand {
    public static final String PROPERTY = "Property";
    @InjectArgs
    private String[] params;
    private Emergency emergency;

    public RegisterPropertyEmergencyCommand(ManagementSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        String description = this.params[1];
        EmergencyLevel lv = EmergencyLevel.valueOf(this.params[2].toUpperCase());
        RegistrationTime registrationTime = new RegistrationTimeImpl(this.params[3]);
        Integer damage = Integer.valueOf(this.params[4]);
        this.emergency = EmergencyFactory.createPropertyHealthEmergency(PROPERTY, description, lv, registrationTime, damage);
        return super.getManagementSystem().registerPropertyEmergency(this.emergency);
    }
}

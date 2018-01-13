package commands;


import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import factory.EmergencyFactory;
import models.emergencies.Emergency;
import utils.RegistrationTimeImpl;
import utils.RegistrationTime;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RegisterOrderEmergencyCommand extends BaseCommand {
    @InjectArgs
    private String[] params;
    private Emergency emergency;

    public RegisterOrderEmergencyCommand(ManagementSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        String description = this.params[1];
        EmergencyLevel lv = EmergencyLevel.valueOf(this.params[2].toUpperCase());
        RegistrationTime registrationTime = new RegistrationTimeImpl(this.params[3]);
        String status = this.params[4];
        this.emergency = EmergencyFactory.createOrderEmergency(description, lv, registrationTime, status);
        return super.getManagementSystem().registerOrderEmergency(this.emergency);
    }
}

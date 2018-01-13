package commands;


import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import factory.EmergencyFactory;
import models.emergencies.Emergency;
import utils.RegistrationTimeImpl;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RegisterHealthEmergencyCommand extends BaseCommand {
    private static final String HEALTH = "Health";
    @InjectArgs
    private String[] params;
    private Emergency emergency;

    public RegisterHealthEmergencyCommand(ManagementSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        String description = this.params[1];
        EmergencyLevel lv = EmergencyLevel.valueOf(this.params[2].toUpperCase());
        RegistrationTimeImpl registrationTimeImpl = new RegistrationTimeImpl(this.params[3]);
        Integer casulaties = Integer.valueOf(this.params[4]);
        this.emergency = EmergencyFactory.createPropertyHealthEmergency(HEALTH, description, lv, registrationTimeImpl, casulaties);
        return super.getManagementSystem().registerHealthEmergency(this.emergency);
    }
}

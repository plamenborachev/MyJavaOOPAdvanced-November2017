package commands;


import annotations.InjectArgs;
import core.ManagementSystem;
import factory.CenterFactory;
import models.centers.EmergencyCenter;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RegisterMedicalServiceCenterCommand extends BaseCommand {
    public static final String MEDICAL = "Medical";
    @InjectArgs
    private String[] params;
    private EmergencyCenter center;

    public RegisterMedicalServiceCenterCommand(ManagementSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        String name = this.params[1];
        Integer additionalParam = Integer.valueOf(this.params[2]);
        this.center = CenterFactory.create(MEDICAL, name, additionalParam);
        return super.getManagementSystem().registerMedicalServiceCenter(this.center);
    }
}

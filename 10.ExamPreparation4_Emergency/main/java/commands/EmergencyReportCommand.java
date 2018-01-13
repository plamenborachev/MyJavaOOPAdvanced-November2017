package commands;


import core.ManagementSystem;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class EmergencyReportCommand extends BaseCommand {

    public EmergencyReportCommand(ManagementSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        return super.getManagementSystem().emergencyReport();
    }
}

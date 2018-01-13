package commands;

import annotations.InjectType;
import core.ManagementSystem;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ProcessEmergenciesCommand extends BaseCommand {
    @InjectType
    private String type;

    public ProcessEmergenciesCommand(ManagementSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        return super.getManagementSystem().processEmergencies(this.type);
    }
}

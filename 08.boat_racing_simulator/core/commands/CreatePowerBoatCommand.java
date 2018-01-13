package core.commands;

import core.BaseCommand;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;

public class CreatePowerBoatCommand extends BaseCommand {
    @Override
    public String execute() throws DuplicateModelException, NonExistantModelException {
        return super.getController().createPowerBoat(super.getParams().get(0), Integer.parseInt(super.getParams().get(1)), super.getParams().get(2), super.getParams().get(3));
    }
}

package core.commands;

import core.BaseCommand;
import exeptions.DuplicateModelException;
import exeptions.NoSetRaceException;
import exeptions.NonExistantModelException;

public class SignUpBoatCommand extends BaseCommand {
    @Override
    public String execute() throws NonExistantModelException, NoSetRaceException, DuplicateModelException {
        return super.getController().signUpBoat(super.getParams().get(0));
    }
}

package core.commands;

import core.BaseCommand;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;

public class CreateYachtCommand extends BaseCommand {
    @Override
    public String execute() throws DuplicateModelException, NonExistantModelException {
        return super.getController().createYacht(super.getParams().get(0), Integer.parseInt(super.getParams().get(1)), super.getParams().get(2), Integer.parseInt(super.getParams().get(3)));
    }
}

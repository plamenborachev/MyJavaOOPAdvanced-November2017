package core.commands;

import core.BaseCommand;
import exeptions.InsufficientContestantsException;
import exeptions.NoSetRaceException;

public class StartRaceCommand extends BaseCommand {
    @Override
    public String execute() throws NoSetRaceException, InsufficientContestantsException {
        return super.getController().startRace();
    }
}

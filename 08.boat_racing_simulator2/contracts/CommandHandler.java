package contracts;

import exceptions.DuplicateModelException;
import exceptions.InsufficientContestantsException;
import exceptions.NoSetRaceException;
import exceptions.NonExistantModelException;
import exceptions.RaceAlreadyExistsException;

public interface CommandHandler {

    String executeCommand(String[] parameters)
            throws DuplicateModelException,
            NonExistantModelException,
            RaceAlreadyExistsException,
            NoSetRaceException,
            InsufficientContestantsException;

}

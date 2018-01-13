package contracts;

import exeptions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CommandHandler {

    String executeCommand(String commandName, List<String> params) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException;
}

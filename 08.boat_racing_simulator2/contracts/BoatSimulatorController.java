package contracts;

import exceptions.DuplicateModelException;
import exceptions.InsufficientContestantsException;
import exceptions.NoSetRaceException;
import exceptions.NonExistantModelException;
import exceptions.RaceAlreadyExistsException;

public interface BoatSimulatorController {

    String createBoatEngine(String model, int horsepower, int displacement, String engineType) throws DuplicateModelException;

    String createRowBoat(String model, int weight, int oars) throws DuplicateModelException;

    String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException;

    String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException;

    String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException;

    String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException;

    String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException;

    String startRace() throws InsufficientContestantsException, NoSetRaceException;

    String getStatistics()throws NoSetRaceException;

}

import contracts.*;
import controllers.BoatSimulatorControllerImpl;
import core.CommandHandlerImpl;
import database.DatabaseImpl;
import database.repositories.BoatEngineRepository;
import database.repositories.BoatRepository;
import engines.Engine;
import io.ConsoleInputReader;
import io.ConsoleOutputWriter;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        CrudRepository<Boat> boatRepository = new BoatRepository();
        CrudRepository<BoatEngine> boatEngineRepository = new BoatEngineRepository();
        Database database = new DatabaseImpl(boatRepository, boatEngineRepository);
        BoatSimulatorController controller = new BoatSimulatorControllerImpl(database);
        CommandHandler commandHandler = new CommandHandlerImpl(controller);
        Engine engine = new Engine(reader, writer, commandHandler);

        engine.run();
    }
}

import contracts.BoatSimulatorController;
import contracts.CommandHandler;
import controllers.DefaultBoatSimulatorController;
import core.DefaultCommandHandler;
import core.Engine;
import database.BoatSimulatorDatabase;

public class Main {

    public static void main(String[] args) {
        BoatSimulatorDatabase database = new BoatSimulatorDatabase();
        BoatSimulatorController controller = new DefaultBoatSimulatorController(database);
        CommandHandler commandHandler = new DefaultCommandHandler(controller);
        Runnable engine = new Engine(commandHandler);
        engine.run();
    }
    
}

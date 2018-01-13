import core.EmergencyManagementSystem;
import core.ManagementSystem;
import engines.Engine;
import interpreters.CommandInterpreter;
import interpreters.Interpreter;
import io.ConsoleReader;
import io.ConsoleWriter;
import io.Reader;
import io.Writer;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        ManagementSystem system = new EmergencyManagementSystem();
        Interpreter interpreter = new CommandInterpreter(system);
        Runnable runnable = new Engine(reader, writer, interpreter);

        runnable.run();
    }
}

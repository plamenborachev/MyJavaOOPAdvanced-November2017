package engines;


import commands.Executable;
import interpreters.Interpreter;
import io.Reader;
import io.Writer;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Engine implements Runnable {
    private static final String INPUT_TERMINATING_COMMAND = "EmergencyBreak";
    private Reader inputReader;
    private Writer outputWriter;
    private Interpreter interpreter;

    public Engine(Reader inputReader, Writer outputWriter, Interpreter interpreter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.interpreter = interpreter;
    }

    @Override
    public void run() {
        try {
            String line = inputReader.read();
            while (true) {
                if (INPUT_TERMINATING_COMMAND.equals(line)) break;
                Executable executable = this.interpreter.interpretCommand(line);
                String executeResult = executable.execute();
                this.outputWriter.write(executeResult);
                line = inputReader.read();
            }
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package interpreters;

import annotations.InjectArgs;
import annotations.InjectType;
import commands.Executable;
import core.ManagementSystem;
import utils.InputParser;
import utils.Parser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CommandInterpreter implements Interpreter {
    private static final String PACKAGE = "commands.";
    private static final String COMMAND_SUFFIX = "Command";
    private ManagementSystem system;
    private Parser parser;

    public CommandInterpreter(ManagementSystem system) {
        this.system = system;
        this.parser = new InputParser();
    }

    @Override
    public Executable interpretCommand(String line) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] params = this.parser.parseInputAsArray(line);
        /*class->ctor->newInstance*/
        Class<Executable> clazz = (Class<Executable>) Class.forName(PACKAGE + params[0] + COMMAND_SUFFIX);
        Constructor<Executable> ctor = clazz.getDeclaredConstructor(ManagementSystem.class);
        Executable executable = ctor.newInstance(this.system);
        this.injectDependencies(executable, params);
        return executable;
    }

    private void injectDependencies(Executable executable, String[] params) throws IllegalAccessException {
        for (Field field : executable.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectArgs.class)) {
                field.setAccessible(true);
                field.set(executable, params);
                break;
            } else if (field.isAnnotationPresent(InjectType.class)) {
                field.setAccessible(true);
                field.set(executable, params[1]);
                break;
            }
        }
    }
}

package cresla;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.Reader;
import cresla.io.Writer;
import cresla.manager.ManagerImpl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Manager manager = new ManagerImpl();
        InputReader reader = new Reader();
        OutputWriter writer = new Writer();

        whileLoop:
        while (true) {
            List<String> commandTokens = Arrays.asList(reader.readLine().split("\\s+"));

            switch (commandTokens.get(0)) {
                case "Reactor":
                    writer.writeLine(manager.reactorCommand(commandTokens));
                    break;
                case "Module":
                    writer.writeLine(manager.moduleCommand(commandTokens));
                    break;
                case "Report":
                    writer.writeLine(manager.reportCommand(commandTokens));
                    break;
                default:
                    writer.writeLine(manager.exitCommand(commandTokens));
                    break whileLoop;
            }
        }
    }
}

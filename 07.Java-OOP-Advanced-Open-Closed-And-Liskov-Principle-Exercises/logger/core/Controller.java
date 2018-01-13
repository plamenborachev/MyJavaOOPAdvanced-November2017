package logger.core;

import logger.commands.CommandInterpreter;
import logger.contracts.*;
import logger.enums.ReportLevel;

public class Controller implements IController {

    private IConsoleInputReader reader;
    private IInputParser parser;
    private CommandInterpreter interpreter;
    private IRepository repository;

    public Controller(IConsoleInputReader reader, IInputParser parser, CommandInterpreter interpreter, IRepository repository) {
        this.reader = reader;
        this.parser = parser;
        this.repository = repository;
        this.interpreter = interpreter;
    }

    @Override
    public void run() {
        int n = Integer.parseInt(this.reader.readLine());
        Appender[] appenders = new Appender[n];

        for (int i = 0; i < n; i++) {
            appenders[i] = this.interpreter.interpretAppenderCommand(this.parser.parseInputAsArray(this.reader.readLine()));
        }

        this.repository.initializeLogger(appenders);

        String message = this.reader.readLine();
        while (!message.equals("END")) {
            Object[] objects = this.interpreter.interpretMessageCommand(this.parser.parseInput(message));
            ReportLevel lv = (ReportLevel) objects[0];
            String f = (String) objects[1];
            String s = (String) objects[2];
            this.repository.putMessageInLogger(lv, f, s);
            message = this.reader.readLine();
        }

        this.repository.print();
    }
}

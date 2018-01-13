package logger.repository;

import logger.contracts.Appender;
import logger.contracts.IRepository;
import logger.contracts.Logger;
import logger.enums.ReportLevel;
import logger.io.ConsoleOutputWriter;
import logger.models.MessageLogger;
import logger.utils.Constants;

public class Repository implements IRepository {
    private Logger logger;

    public void initializeLogger(Appender... appenders) {
        this.logger = new MessageLogger(appenders);
    }

    public void putMessageInLogger(ReportLevel level, String dateAndTime, String msg) {
        this.logger.logLevel(level, dateAndTime, msg);
    }

    @Override
    public void print() {
        ConsoleOutputWriter.writeLine(Constants.LOGGER_INFO);
        System.out.println(this.logger);
    }
}

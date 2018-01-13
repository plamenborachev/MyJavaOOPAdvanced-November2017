package logger.contracts;

import logger.enums.ReportLevel;

public interface IRepository {
    void initializeLogger(Appender... appenders);

    void putMessageInLogger(ReportLevel level, String dateAndTime, String msg);

    void print();
}

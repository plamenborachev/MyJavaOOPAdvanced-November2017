package logger.contracts;

import logger.enums.ReportLevel;

public interface IAppenderFactory {
    Appender getAppender(String type, Layout layout, ReportLevel level);
}

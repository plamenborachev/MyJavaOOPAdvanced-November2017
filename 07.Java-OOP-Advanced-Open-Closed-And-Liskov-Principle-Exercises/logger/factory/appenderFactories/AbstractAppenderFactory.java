package logger.factory.appenderFactories;

import logger.contracts.Appender;
import logger.contracts.IAppenderFactory;
import logger.contracts.Layout;
import logger.enums.ReportLevel;
import logger.models.LogFile;
import logger.models.appenders.ConsoleAppender;
import logger.models.appenders.FileAppender;
import logger.utils.Constants;

public class AbstractAppenderFactory implements IAppenderFactory {

    @Override
    public Appender getAppender(String type, Layout layout, ReportLevel level) {
        if (type.equals(Constants.CONSOLE_APPENDER)) {
            return new ConsoleAppender(layout, level);
        } else if (type.equals(Constants.FILE_APPENDER)) {
            FileAppender fileAppender = new FileAppender(layout, level);
            fileAppender.setFile(new LogFile());
            return fileAppender;
        }
        return null;
    }
}

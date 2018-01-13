package logger.models.appenders;

import logger.contracts.Layout;
import logger.enums.ReportLevel;
import logger.io.ConsoleOutputWriter;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout, ReportLevel level) {
        super(layout, level);
    }

    public void appendMessage(ReportLevel level, String dateAndTime, String message) {
        if (super.getLevel().ordinal() <= level.ordinal()) {
            String formattedMessage = String.format(super.getLayout().getFormat(), dateAndTime, level.name(), message);
            ConsoleOutputWriter.writeLine(formattedMessage);
            super.messagesCount++;
        }
    }

}

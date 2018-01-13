package logger.models.appenders;

import logger.contracts.File;
import logger.contracts.Layout;
import logger.enums.ReportLevel;

public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout, ReportLevel level) {
        super(layout, level);
    }

    public void appendMessage(ReportLevel level, String dateAndTime, String message) {
        if (super.getLevel().ordinal() <= level.ordinal()) {
            String formattedMessage = String.format(super.getLayout().getFormat(), dateAndTime, level.name(), message);
            this.file.write(formattedMessage);
            super.messagesCount++;
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString().concat(String.format(", File size: %d", this.file.getSize()));
    }
}

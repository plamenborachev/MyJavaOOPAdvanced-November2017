package logger.models.appenders;

import logger.contracts.Appender;
import logger.contracts.Layout;
import logger.enums.ReportLevel;

public abstract class BaseAppender implements Appender {
    private Layout layout;
    private ReportLevel level;
    protected int messagesCount = 0;

    BaseAppender(Layout layout, ReportLevel level) {
        this.layout = layout;
        this.setReportLevel(level);
    }

    @Override
    public void setReportLevel(ReportLevel level) {
        if (level == null) {
            this.level = DEFAULT_REPORT_LEVEL;
        } else {
            this.level = level;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Appender type: ");
        builder.append(String.format("%s, Layout type: %s, Report level: %s, ", this.getClass().getSimpleName(), this.getLayout().getClass().getSimpleName(), this.getLevel().name()));
        builder.append(String.format("Messages appended: %d", this.messagesCount));
        return builder.toString();
    }

    @Override
    public ReportLevel getLevel() {
        return this.level;
    }

    @Override
    public Layout getLayout() {
        return layout;
    }

}

package logger.models.layouts;

import logger.contracts.Layout;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class XmlLayout implements Layout {
    private final String format = "<log>%n\t<date>%s</date>%n\t<level>%s</level>%n\t<message>%s</message>%n</log>";

    public String getFormat() {
        return format;
    }
}

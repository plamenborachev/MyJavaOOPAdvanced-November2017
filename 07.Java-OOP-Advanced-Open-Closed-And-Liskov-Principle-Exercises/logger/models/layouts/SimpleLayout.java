package logger.models.layouts;

import logger.contracts.Layout;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SimpleLayout implements Layout {
    private final String format = "%s - %s - %s";

    public String getFormat() {
        return format;
    }
}

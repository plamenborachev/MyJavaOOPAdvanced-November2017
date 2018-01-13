package logger.factory.layoutFactories;

import logger.contracts.ILayoutFactory;
import logger.contracts.Layout;
import logger.models.layouts.SimpleLayout;
import logger.models.layouts.XmlLayout;
import logger.utils.Constants;

public class AbstractLayoutFactory implements ILayoutFactory {

    @Override
    public Layout getLayout(String type) {
        if (type.equals(Constants.SIMPLE_LAYOUT)) {
            return new SimpleLayout();
        } else if (type.equals(Constants.XML_LAYOUT)) {
            return new XmlLayout();
        }
        return null;
    }
}

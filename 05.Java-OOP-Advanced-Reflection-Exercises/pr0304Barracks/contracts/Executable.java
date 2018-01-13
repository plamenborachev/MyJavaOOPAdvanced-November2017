package pr0304Barracks.contracts;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

	String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException,
            NoSuchMethodException, IllegalAccessException;

}

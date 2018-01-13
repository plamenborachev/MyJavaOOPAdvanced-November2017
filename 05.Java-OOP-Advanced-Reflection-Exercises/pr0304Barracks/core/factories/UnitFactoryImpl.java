package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		// TODO: implement for problem 3
		Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
		Constructor<?> constructor = unitClass.getDeclaredConstructor();
		Unit unit = (Unit) constructor.newInstance();
		return unit;
//		throw new NotImplementedException();
	}
}

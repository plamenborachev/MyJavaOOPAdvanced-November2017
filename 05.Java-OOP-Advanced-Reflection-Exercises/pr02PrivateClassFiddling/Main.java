package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Class aClass = BlackBoxInt.class;
        Constructor[] constructors = aClass.getDeclaredConstructors();
        constructors[1].setAccessible(true);

        BlackBoxInt blackBoxInt = (BlackBoxInt) constructors[1].newInstance();

        Field field = blackBoxInt.getClass().getDeclaredField("innerValue");
        field.setAccessible(true);

        String[] command = reader.readLine().split("_");

        while (!"END".equals(command[0])){
            int value = Integer.parseInt(command[1]);
            Method method = null;
            switch (command[0]){
                case "add":
                    method = blackBoxInt.getClass().getDeclaredMethod("add", int.class);
                    break;
                case "subtract":
                    method = blackBoxInt.getClass().getDeclaredMethod("subtract", int.class);
                    break;
                case "divide":
                    method = blackBoxInt.getClass().getDeclaredMethod("divide", int.class);
                    break;
                case "multiply":
                    method = blackBoxInt.getClass().getDeclaredMethod("multiply", int.class);
                    break;
                case "rightShift":
                    method = blackBoxInt.getClass().getDeclaredMethod("rightShift", int.class);
                    break;
                case "leftShift":
                    method = blackBoxInt.getClass().getDeclaredMethod("leftShift", int.class);
                    break;
            }
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);
            System.out.println(field.get(blackBoxInt));

            command = reader.readLine().split("_");
        }
	}
}

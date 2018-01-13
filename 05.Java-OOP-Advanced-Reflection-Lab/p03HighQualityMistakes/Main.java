package p03HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {

        Class reflectionClass = Reflection.class;

        Field[] fields = Arrays.stream(reflectionClass.getDeclaredFields())
                .sorted(Comparator.comparing(Field::getName))
                .toArray(Field[]::new);

        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers())){
                System.out.println(String.format("%s must be private!", field.getName()));
            }
        }

        Method[] methods = reflectionClass.getDeclaredMethods();

        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();

        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0){
                getters.add(method);
            }
            if(method.getName().startsWith("set")
                    && method.getParameterCount() == 1
                    && void.class.equals(method.getReturnType())){
                setters.add(method);
            }
        }

        for (Method getter : getters.stream()
                .sorted(Comparator.comparing(Method::getName))
                .collect(Collectors.toList())) {
            if (!Modifier.isPublic(getter.getModifiers())){
                System.out.println(String.format("%s have to be public!",
                        getter.getName()));
            }
        }

        for (Method setter : setters.stream()
                .sorted(Comparator.comparing(Method::getName))
                .collect(Collectors.toList())) {
            if (!Modifier.isPrivate(setter.getModifiers())){
                System.out.println(String.format("%s have to be private!",
                        setter.getName()));
            }
        }
    }
}

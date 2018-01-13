package p02GettersAndSetters;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {

        Class reflectionClass = Reflection.class;

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
            System.out.println(String.format("%s will return %s",
                    getter.getName(), getter.getReturnType()));
        }

        for (Method setter : setters.stream()
                .sorted(Comparator.comparing(Method::getName))
                .collect(Collectors.toList())) {
            System.out.println(String.format("%s and will set field of %s",
                    setter.getName(), setter.getParameterTypes()[0]));
        }
    }
}

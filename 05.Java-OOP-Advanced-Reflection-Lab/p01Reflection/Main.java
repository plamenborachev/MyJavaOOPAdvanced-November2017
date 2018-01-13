package p01Reflection;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        Class reflectionClass = Reflection.class;

        Class superClassType = reflectionClass.getSuperclass();
        Class[] interfaces = reflectionClass.getInterfaces();

        System.out.println(reflectionClass);
        System.out.println(superClassType);
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Reflection ref = (Reflection) reflectionClass.newInstance();
        System.out.println(ref);
    }
}

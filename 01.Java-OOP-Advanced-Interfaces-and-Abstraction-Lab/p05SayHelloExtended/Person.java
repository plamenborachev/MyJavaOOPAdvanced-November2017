package p05SayHelloExtended;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello";
    }
}

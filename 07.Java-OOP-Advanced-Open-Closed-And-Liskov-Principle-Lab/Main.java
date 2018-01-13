import P01_ExtendedArrayList.ExtendedArrayList;

public class Main {
    public static void main(String[] args) {
        ExtendedArrayList<String> someList = new ExtendedArrayList<>();

        someList.add("a");
        someList.add("b");
        someList.add("c");
        someList.add("d");

        System.out.println(someList.min());
        System.out.println(someList.max());
    }
}

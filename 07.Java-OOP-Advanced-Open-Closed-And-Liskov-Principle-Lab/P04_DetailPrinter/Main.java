package P04_DetailPrinter;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Pesho");
        Employee manager = new Manager("Gosho", new ArrayList<String>(){{add("docs");}});

        DetailsPrinter dp = new DetailsPrinter(Arrays.asList(employee, manager));

        dp.printDetails();
    }
}

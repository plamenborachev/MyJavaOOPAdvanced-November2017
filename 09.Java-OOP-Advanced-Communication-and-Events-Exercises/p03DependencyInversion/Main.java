package p03DependencyInversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Strategy addition = new AdditionStrategy();
        Strategy subtraction = null;
        Strategy multiply = null;
        Strategy divide = null;

        PrimitiveCalculator calculator = new PrimitiveCalculator(addition);

        String[] line = reader.readLine().split("\\s+");

        while (!"End".equals(line[0])){
            if ("mode".equals(line[0])){
                switch (line[1]){
                    case "+":
                        calculator.setStrategy(addition);
                        break;
                    case "-":
                        subtraction = new SubtractionStrategy();
                        calculator.setStrategy(subtraction);
                        break;
                    case "*":
                        multiply = new MultiplicationStrategy();
                        calculator.setStrategy(multiply);
                        break;
                    case "/":
                        divide = new DivisionStrategy();
                        calculator.setStrategy(divide);
                        break;
                }
            } else {
                int firstOperand = Integer.parseInt(line[0]);
                int secondOperand = Integer.parseInt(line[1]);
                System.out.println(calculator.performCalculation(firstOperand, secondOperand));
            }
            line = reader.readLine().split("\\s+");
        }
    }
}

package p03DependencyInversion;

public class SubtractionStrategy implements Strategy{

    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}

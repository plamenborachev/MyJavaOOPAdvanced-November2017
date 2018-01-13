package p03DependencyInversion;

public class AdditionStrategy implements Strategy{

    @Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand + secondOperand;
    }
}

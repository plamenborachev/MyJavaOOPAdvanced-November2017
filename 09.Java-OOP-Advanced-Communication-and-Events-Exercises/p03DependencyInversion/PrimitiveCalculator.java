package p03DependencyInversion;


public class PrimitiveCalculator {

    private Strategy strategy;

    public PrimitiveCalculator(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int performCalculation(int firstOperand, int secondOperand) {
        return this.strategy.calculate(firstOperand, secondOperand);
    }
}

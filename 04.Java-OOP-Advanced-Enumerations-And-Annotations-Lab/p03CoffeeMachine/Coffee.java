package p03CoffeeMachine;

public class Coffee {
    private CoffeeSize coffeeSize;
    private CoffeeType coffeeType;

    public Coffee(CoffeeSize coffeeSize, CoffeeType coffeeType) {
        this.coffeeSize = coffeeSize;
        this.coffeeType = coffeeType;
    }

    public CoffeeSize getCoffeeSize() {
        return this.coffeeSize;
    }

    @Override
    public String toString() {
        String coffeeSize = this.coffeeSize.name().charAt(0) + this.coffeeSize.name().substring(1).toLowerCase();
        String coffeeType = this.coffeeType.name().charAt(0) + this.coffeeType.name().substring(1).toLowerCase();
        return coffeeSize + " " + coffeeType;
    }
}

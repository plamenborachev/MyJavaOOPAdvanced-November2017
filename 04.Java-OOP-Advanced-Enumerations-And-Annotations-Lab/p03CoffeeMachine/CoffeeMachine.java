package p03CoffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> coffeesSold;
    private List<Coin> coins;

    public CoffeeMachine() {
        this.coffeesSold = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public void buyCoffee(String size, String type){
        CoffeeSize coffeeSize = CoffeeSize.valueOf(size.toUpperCase());
        CoffeeType coffeeType = CoffeeType.valueOf(type.toUpperCase());
        Coffee coffee = new Coffee(coffeeSize, coffeeType);
        if (this.coins.stream().mapToInt(Coin::getValue).sum() >= coffee.getCoffeeSize().getPrice()){
            this.coffeesSold.add(coffee);
        }
        this.coins.clear();
    }

    public void insertCoin(String coin){
        this.coins.add(Coin.valueOf(coin));
    }

    public Iterable<Coffee> coffeesSold(){
        return this.coffeesSold;
    }
}

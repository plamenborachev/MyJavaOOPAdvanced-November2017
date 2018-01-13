package p03CoffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] command = reader.readLine().split("\\s+");

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (!"END".equals(command[0])){
            if(command.length == 1){
                coffeeMachine.insertCoin(command[0]);
            } else if (command.length == 2){
                String size = command[0];
                String type = command[1];
                coffeeMachine.buyCoffee(size, type);
            }
            command = reader.readLine().split("\\s+");
        }

        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}

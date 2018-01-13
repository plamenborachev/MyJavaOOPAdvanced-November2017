package p07FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, Buyer> buyers = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            Buyer buyer = null;
            if (input.length == 4){
                String name = input[0];
                Integer age = Integer.parseInt(input[1]);
                String id = input[2];
                String birthday = input[3];
                buyer = new Citizen(id, name, age, birthday);
            } else if (input.length == 3){
                String name = input[0];
                Integer age = Integer.parseInt(input[1]);
                String group = input[2];
                buyer = new Rebel(name, age, group);
            }
            buyers.putIfAbsent(buyer.getName(), buyer);
        }

        String name = reader.readLine();

        while(!"End".equals(name)){
            if(buyers.containsKey(name)){
                buyers.get(name).buyFood();
            }
            name = reader.readLine();
        }

        int foodPurchased = buyers.values().stream().mapToInt(Buyer::getFood).sum();

        System.out.println(foodPurchased);
    }
}

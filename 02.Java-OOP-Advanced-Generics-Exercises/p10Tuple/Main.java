package p10Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String[] input = reader.readLine().split("\\s+");
            Tuple tuple = null;
            if (i == 0){
                String name = input[0] + " " + input[1];
                String address = input[2];
                tuple = new Tuple(name, address);

            } else if (i == 1){
                String name = input[0];
                int litersOfBeer = Integer.parseInt(input[1]);
                tuple = new Tuple(name, litersOfBeer);

            } else if (i == 2){
                int intNumber = Integer.parseInt(input[0]);
                double doubleNumber = Double.parseDouble(input[1]);
                tuple = new Tuple(intNumber, doubleNumber);
            }
            System.out.println(tuple);
        }
    }
}

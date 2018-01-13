package p11Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = reader.readLine().split("\\s+");
        String name = input1[0] + " " + input1[1];
        String address = input1[2];
        String town = input1[3];
        Tuple<String, String, String> tuple1 = new Tuple(name, address, town);

        String[] input2 = reader.readLine().split("\\s+");
        name = input2[0];
        int litersOfBeer = Integer.parseInt(input2[1]);
        boolean drunkOrNot = true ? input2[2].equals("drunk") : false;
        Tuple<String, Integer, String> tuple2 = new Tuple(name, litersOfBeer, drunkOrNot);


        String[] input3 = reader.readLine().split("\\s+");
        name = input3[0];
        double accountBalance = Double.parseDouble(input3[1]);
        String bankName = input3[2];
        Tuple<String, Double, String> tuple3 = new Tuple(name, accountBalance, bankName);

        System.out.println(tuple1);
        System.out.println(tuple2);
        System.out.println(tuple3);

    }
}

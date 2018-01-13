package p01CardSuit;

import p01CardSuit.CardSuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        CardSuits[] cardSuits = CardSuits.values();

        System.out.println(input + ":");
        for (CardSuits cardSuite: cardSuits) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    cardSuite.ordinal(), cardSuite.name()));
        }
    }
}

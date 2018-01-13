package p02CardRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String input = reader.readLine();
        
        CardRanks[] cardRanks = CardRanks.values();

        System.out.println(input + ":");
        for (CardRanks cardRank : cardRanks) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    cardRank.ordinal(), cardRank));
        }
    }
}

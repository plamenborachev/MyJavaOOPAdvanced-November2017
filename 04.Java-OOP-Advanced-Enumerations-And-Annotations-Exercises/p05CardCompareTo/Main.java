package p05CardCompareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Card[] cards = new Card[2];

        for (int i = 0; i < 2; i++) {
            String rank = reader.readLine();
            String suit = reader.readLine();

            CardRanks cardRank = CardRanks.valueOf(rank);
            CardSuits cardSuit = CardSuits.valueOf(suit);
            Card card = new Card(cardRank, cardSuit);

            cards[i] = card;
        }

        if (cards[0].compareTo(cards[1]) > 0){
            System.out.println(cards[0]);
        } else {
            System.out.println(cards[1]);
        }
    }
}

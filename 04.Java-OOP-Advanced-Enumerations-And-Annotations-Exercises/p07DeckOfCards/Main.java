package p07DeckOfCards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        CardRanks[] cardRanksValues = CardRanks.values();
        CardSuits[] cardSuitsValues = CardSuits.values();

        List<Card> cardList = new ArrayList<>();

        Card card = null;

        for (int i = 0; i < cardSuitsValues.length; i++) {
            for (int j = 0; j < cardRanksValues.length; j++) {
                card = new Card(cardRanksValues[j], cardSuitsValues[i]);
                cardList.add(card);
            }
        }

        for (Card item : cardList) {
            System.out.println(item);
        }
    }
}

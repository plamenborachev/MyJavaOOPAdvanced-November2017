package p08CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private List<Card> cards;

    public CardDeck() {
        this.setCards();
    }

    private void setCards(){
        this.cards = new ArrayList<>();

        CardRanks[] cardRanksValues = CardRanks.values();
        CardSuits[] cardSuitsValues = CardSuits.values();

        for (int i = 0; i < cardSuitsValues.length; i++) {
            for (int j = 0; j < cardRanksValues.length; j++) {
                Card card = new Card(cardRanksValues[j].name(), cardSuitsValues[i].name());
                this.cards.add(card);
            }
        }
    }

    public List<Card> getCards(){
        return Collections.unmodifiableList(this.cards);
    }

    public void removeCard(Card card){
        this.cards.remove(card);
    }
}

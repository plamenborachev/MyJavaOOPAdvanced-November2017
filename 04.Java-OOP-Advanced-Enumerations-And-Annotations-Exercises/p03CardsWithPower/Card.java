package p03CardsWithPower;

public class Card {
    private CardRanks cardRank;
    private CardSuits cardSuit;

    public Card(CardRanks cardRank, CardSuits cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public CardRanks getCardRank() {
        return this.cardRank;
    }

    public CardSuits getCardSuit() {
        return this.cardSuit;
    }

    public int getCardPower(){
        return this.cardRank.getPower() + this.cardSuit.getPower();
    }
}

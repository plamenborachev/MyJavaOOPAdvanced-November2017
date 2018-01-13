package p07DeckOfCards;

public class Card implements Comparable<Card>{
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

    @Override
    public String toString(){
        return String.format("%s of %s",
                this.cardRank, this.cardSuit, this.getCardPower());
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getCardPower(), o.getCardPower());
    }
}

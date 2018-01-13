package p08CardGame;

public class Card implements Comparable<Card> {
    private CardRanks cardRank;
    private CardSuits cardSuit;

    public Card(String cardRank, String cardSuit) {
        this.setCardRank(cardRank);
        this.setCardSuit(cardSuit);
    }

    public void setCardRank(String cardRank) {

        this.cardRank = CardRanks.valueOf(cardRank);
    }

    public void setCardSuit(String cardSuit) {
        this.cardSuit = CardSuits.valueOf(cardSuit);
    }

    public int getCardPower() {
        return this.cardRank.getPower() + this.cardSuit.getPower();
    }

    @Override
    public String toString() {
        return String.format("%s of %s",
                this.cardRank, this.cardSuit);
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getCardPower(), o.getCardPower());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj != null && obj instanceof Card) {
            isEqual = (this.cardRank == ((Card) obj).cardRank) && (this.cardSuit == ((Card) obj).cardSuit);
        }
        return isEqual;
    }
}

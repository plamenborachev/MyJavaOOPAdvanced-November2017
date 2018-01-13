package p08CardGame;

public class Game {
    private Player playerOne;
    private Player playerTwo;
    private CardDeck cardDeck;

    public Game(String playerOne, String playerTwo) {
        this.playerOne = new Player(playerOne);
        this.playerTwo = new Player(playerTwo);
        this.cardDeck = new CardDeck();
    }

    public Player getPlayerOne() {
        return this.playerOne;
    }

    public Player getPlayerTwo() {
        return this.playerTwo;
    }

    public void addCardToPlayer(Player player, Card card) {
        if (!this.cardDeck.getCards().contains(card)) {
            throw new IllegalArgumentException("Card is not in the deck.");
        }
        player.addCard(card);
        this.cardDeck.removeCard(card);
    }

    public Card getBestCard(Player player) {
        Card playerBestCard = player.getCards().get(0);
        for (Card card : player.getCards()) {
            if (Integer.compare(card.getCardPower(), playerBestCard.getCardPower()) > 0) {
                playerBestCard = card;
            }
        }
        return playerBestCard;
    }

    public String getWinner(Card playerOneBestCard, Card playerTwoBestCard) {
        if (playerOneBestCard.compareTo(playerTwoBestCard) > 0) {
            return String.format("%s wins with %s.", this.playerOne.getName(), playerOneBestCard);
        }
        return String.format("%s wins with %s.", this.playerTwo.getName(), playerTwoBestCard);
    }
}

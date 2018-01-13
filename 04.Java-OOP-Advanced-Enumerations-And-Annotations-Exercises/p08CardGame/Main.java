package p08CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String playerOneName = reader.readLine();
        String playerTwoName = reader.readLine();

        Game game = new Game(playerOneName, playerTwoName);

        addFiveCardsToPlayer(reader, game, game.getPlayerOne());
        addFiveCardsToPlayer(reader, game, game.getPlayerTwo());

        System.out.println(game.getWinner(game.getBestCard(game.getPlayerOne()),
                game.getBestCard(game.getPlayerTwo())));
    }

    private static void addFiveCardsToPlayer(BufferedReader reader, Game game, Player player) throws IOException {
        while (player.getCards().size() < 5) {
            String[] cardTokens = reader.readLine().split(" of ");
            String cardRank = cardTokens[0];
            String cardSuit = cardTokens[1];
            Card card = null;
            try{
                card = new Card(cardRank, cardSuit);
            } catch (IllegalArgumentException iae){
                System.out.println("No such card exists.");
            }
            if (card != null) {
                try{
                    game.addCardToPlayer(player, card);
                } catch (IllegalArgumentException iae){
                    System.out.println(iae.getMessage());
                }
            }
        }
    }
}

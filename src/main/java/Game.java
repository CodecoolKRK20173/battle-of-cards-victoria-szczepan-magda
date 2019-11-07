package main.java;

import java.util.*;

public class Game {

    private List<Card> deck;
    private Table table;
    private XMLParser xmlParser;
    private Player player1;
    private Player player2;

    Game() {
        player1 = new PlayerHuman("player1");
        player2 = new PlayerHuman("player2");
        deck = new ArrayList<>();
        table = new Table(player1, player2);
        xmlParser = new XMLParser();
    }

    public void loadCardsToDeck() {
        deck = xmlParser.loadFromFile("src/main/resources/Cars.xml");
    }

    public void shuffleCards() {
        Collections.shuffle(deck);
    }

    public void dealCards() {
        for (int i = 0; i < deck.size(); i++) {
            if (i % 2 == 0) {
                player1.addCardToDeck(deck.get(i));
            } else {
                player2.addCardToDeck(deck.get(i));
            }
        }
    }

    public void turn(Player player) {
        View.clearScreen();
        Card topCard = player.getTopCardFromHand();
        String userChoice = player.displayParametersAndGetChoice(topCard);
        Boolean isResolved;
        do {
            table.getTopCards();
            View.display(table.toString());
            isResolved = table.getBattleResult(player, userChoice);
        } while (isResolved == null && !player1.isHandEmpty());
        if (isResolved) {
            announceWinner(player);
        }else {
            announceWinner(findOppositePlayer(player));
            }
        View.displayPoints(player1, player2);

        table.removeAll();
    }

    private Player findOppositePlayer(Player player) {
        if (player.equals(player1)) {
            return player2;
        }
        else{
            return player1;
        }
    }

    private void announceWinner(Player player) {
        View.display(player.getName() + " wins round! And gets " + table.countCardsOnTable() + " points!\n");
        player.addPoints(table.countCardsOnTable());
    }




    private String getWinner(){
        if (player1.getPoints() > player2.getPoints()){
            return player1.getName();
        }
        else if (player1.getPoints() < player2.getPoints()){
            return player2.getName();
        }
        else {
            return "Nobody";
        }
    }

    public void play() {
        loadCardsToDeck();
        shuffleCards();
        dealCards();
        while(!player1.isHandEmpty()) {
            turn(player1);
            if(!player2.isHandEmpty())
            turn(player2);
        }
        View.display(getWinner() + " wins the game!");
    }

}

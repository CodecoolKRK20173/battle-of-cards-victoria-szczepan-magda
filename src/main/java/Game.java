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
                player1.getHand().addCard(deck.get(i));
            } else {
                player2.getHand().addCard(deck.get(i));
            }
        }
    }

    public void turn(Player player) {
        View.display(player.getHand().getTopCard().toString());
        View.printParametersToChoose(player.getHand().getTopCard().getParametersKeys());
        String userChoice = handleUserChoice();
        Boolean isResolved;
        do {
            table.getTopCards();
            View.display(table.toString());
            isResolved = table.getBattleResult(player, userChoice);
        } while (isResolved == null);



        if (isResolved) {
            if (player.equals(player1)) {
                announceWinner(player1);
            } else {
                announceWinner(player2);
            }
        } else {
            if (player.equals(player1)) {
                announceWinner(player2);
            } else {
                announceWinner(player1);
            }
        }

        table.removeAll();

    }

    private void announceWinner(Player player) {
        View.display(player.getName() + " wins round! And gets " + table.countCardsOnTable() + " points!");
        player.addPoints(table.countCardsOnTable());
    }


    private String handleUserChoice() {
        String parameter = "";
        if (View.getUserInput().equals("1")) {
            parameter = "maxSpeed";
        } else if (View.getUserInput().equals("2")) {
            parameter = "acceleration";
        } else if(View.getUserInput().equals("3")) {
            parameter = "price";
        }
        return parameter;
    }

    private String getWinner(){
        if (player1.getPoints() > player2.getPoints()){
            return player1.getName();
        }
        else if (player1.getPoints() < player2.getPoints()){
            return player2.getName();
        }
        else {
            return "";
        }
    }

    public void play() {
        loadCardsToDeck();
        shuffleCards();
        dealCards();
        while(!player1.getHand().isEmpty()) {
            turn(player1);
            turn(player2);
        }
        View.display(getWinner() + " wins the game!");
    }

}

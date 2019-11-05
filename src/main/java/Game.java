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

    }



    public void play() {
        loadCardsToDeck();
        shuffleCards();
        dealCards();
        while(!player1.getHand().isEmpty()) {
            turn(player1);
            turn(player2);
        }
    }

}

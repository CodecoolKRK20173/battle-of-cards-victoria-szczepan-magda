package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {

    private Player player1;
    private Player player2;
    private List<Card> topCards1;
    private List<Card> topCards2;

    private Map<Player, List<Card>> cardsOnTable;

    Table() {
        player1 = new PlayerHuman("player1");
        player2 = new PlayerHuman("player2");

        topCards1 = new ArrayList<>();
        topCards2 = new ArrayList<>();

        cardsOnTable = new HashMap<>();
    }


    public void removeAll() {
        cardsOnTable.clear();
    }

    public void addTopCards(Card card1, Card card2) {
        topCards1.add(card1);
        topCards2.add(card2);
        cardsOnTable.put(player1, topCards1);
        cardsOnTable.put(player2, topCards2);
    }

    public int countCardsOnTable() {
        return 0;
    }



}

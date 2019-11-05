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

    Table(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        topCards1 = new ArrayList<>();
        topCards2 = new ArrayList<>();

        cardsOnTable = new HashMap<>();
    }


    public void removeAll() {
        cardsOnTable.clear();
    }

    private void addTopCards(Card card1, Card card2) {
        topCards1.add(card1);
        topCards2.add(card2);
        cardsOnTable.put(player1, topCards1);
        cardsOnTable.put(player2, topCards2);
    }

    public void getTopCards() {
        Card topCard1 = player1.getHand().getTopCard();
        player1.getHand().removeTopCard();
        Card topCard2 = player2.getHand().getTopCard();
        player2.getHand().removeTopCard();
        addTopCards(topCard1, topCard2);
    }

    public Boolean getBattleResult(Player player) {
        Boolean isResolved = null;
        if (player.equals(player1)) {
            isResolved = topCards1.get(topCards1.size() - 1).compare(topCards2.get(topCards2.size() - 1));
        } else {
            isResolved = topCards2.get(topCards2.size() - 1).compare(topCards1.get(topCards1.size() - 1));
        }
        return isResolved;
    }

    public int countCardsOnTable() {
        return topCards1.size() + topCards2.size();
    }

    public String toString() {
        String cardToPrint = "";
        cardToPrint += "First player's card:\n" + topCards1.get(topCards1.size() - 1).toString() + "\n";
        cardToPrint += "Second player's card:\n" + topCards2.get(topCards2.size() - 1).toString() + "\n";

        return cardToPrint;
    }



}

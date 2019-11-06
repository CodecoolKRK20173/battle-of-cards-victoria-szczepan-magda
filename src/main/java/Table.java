package main.java;

import java.util.*;

public class Table {

    private Player player1;
    private Player player2;
    private int player1LastCardIndex;
    private int player2lastCardIndex;
    private List<Card> player1TopCards;
    private List<Card> player2TopCards;

    private Map<Player, List<Card>> cardsOnTable;

    Table(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        player1LastCardIndex = player1TopCards.size() - 1;
        player2lastCardIndex = player2TopCards.size() - 1;

        player1TopCards = new ArrayList<>();
        player2TopCards = new ArrayList<>();
        cardsOnTable = new LinkedHashMap<>();
    }


    public void removeAll() {
        Iterator<Map.Entry<Player, List<Card>>> iter = cardsOnTable.entrySet().iterator();
        while(iter.hasNext()){
            cardsOnTable.remove(iter.next().getKey(), iter.next().getValue());
        }
        player1TopCards.clear();
        player2TopCards.clear();
    }

    private void addTopCards(Card card1, Card card2) {
        player1TopCards.add(card1);
        player2TopCards.add(card2);
        cardsOnTable.put(player1, player1TopCards);
        cardsOnTable.put(player2, player2TopCards);
    }

    public void getTopCards() {
        Card topCard1 = player1.getTopCardFromHand();
        player1.removeTopCardFromHand();
        Card topCard2 = player2.getTopCardFromHand();
        player2.removeTopCardFromHand();
        addTopCards(topCard1, topCard2);
    }

    public Boolean getBattleResult(Player player, String parameter) {
        Boolean isResolved = null;
        if (player.equals(player1)) {
            isResolved = player1TopCards.get(player1LastCardIndex).compareCards(player2TopCards.get(player2lastCardIndex), parameter);
        } else {
            isResolved = player2TopCards.get(player2lastCardIndex).compareCards(player1TopCards.get(player1LastCardIndex), parameter);
        }
        return isResolved;
    }

    public int countCardsOnTable() {
        return player1TopCards.size() + player2TopCards.size();
    }

    public String toString() {
        String cardToPrint = "";
        cardToPrint += "First player's card:\n" + player1TopCards.get(player1LastCardIndex).toString() + "\n";
        cardToPrint += "Second player's card:\n" + player2TopCards.get(player2lastCardIndex).toString() + "\n";

        return cardToPrint;
    }



}

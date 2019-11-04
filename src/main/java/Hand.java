package main.java;

import java.util.*;

public class Hand{

    private List<Card> cards = new ArrayList<Card>();

    public void addCard(Card card){
        cards.add(card);
    }

    public Card getTopCard(){
       int lastElementIndex = cards.size() - 1;
        return cards.get(lastElementIndex);
    }

    public void removeTopCard(){
        int lastElementIndex = cards.size() - 1;
        cards.remove(lastElementIndex);
    }

}
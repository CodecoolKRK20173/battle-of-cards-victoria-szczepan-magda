package main.java;

import java.util.List;

public class Main{
    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        List<Card> cards = parser.loadFromFile("src/main/resources/Cars.xml");
        for (Card card: cards) {
            System.out.println(card.toString());
        }
    }
}
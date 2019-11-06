package main.java;

public class PlayerHuman extends Player {

    private Hand hand;
    private int points;
    private String name;

    public PlayerHuman(String name) {
        this.name = name;
        this.points = 0;
        this.hand = new Hand();
    }

    @Override
    public Hand getHand() {
        return this.hand;
    }

    @Override
    public void addPoints(int pointsAmount) {
        this.points += pointsAmount;
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Card getTopCardFromHand() {
        return hand.getTopCard();
    }

    @Override
    public boolean isHandEmpty() {
        return hand.isEmpty();
    }
}

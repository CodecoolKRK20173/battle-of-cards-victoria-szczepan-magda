package main.java;

public abstract class Player {

    private Hand hand;
    private int points;
    private String name;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.hand = new Hand();
    }

    public Hand getHand() {
        return this.hand;
    }

    public void addPoints(int pointsAmount) {
        this.points += pointsAmount;
    }

    public int getPoints() {
        return this.points;
    }

    public String getName() {
        return this.name;
    }

    public Card getTopCardFromHand() {
        return hand.getTopCard();
    }

    public boolean isHandEmpty() {
        return hand.isEmpty();
    }

    public void addCardToDeck(Card card) {
        hand.addCard(card);
    }

    public void removeTopCardFromHand() {
        hand.removeTopCard();
    }

    public abstract String displayParametersAndGetChoice(Card topCard);

    public String handleUserChoice(String userInput) {
        String parameter = "";
        if (userInput.equals("1")) {
            parameter = "maxSpeed";
        } else if (userInput.equals("2")) {
            parameter = "price";
        } else if(userInput.equals("3")) {
            parameter = "acceleration";
        }
        View.display("\nChosen parameter: " + parameter + "\n\n");
        return parameter;
    }

}

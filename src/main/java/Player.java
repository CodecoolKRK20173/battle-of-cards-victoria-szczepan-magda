package main.java;

public abstract class Player {

    public abstract Hand getHand();

    public abstract void addPoints(int pointsAmount);

    public abstract int getPoints();

    public abstract String getName();

    public abstract Card getTopCardFromHand();

    public abstract boolean isHandEmpty();

    public abstract void addCardToDeck(Card card);

    public abstract void removeTopCardFromHand();

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
        return parameter;
    }

}

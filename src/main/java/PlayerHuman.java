package main.java;

public class PlayerHuman extends Player {


    public PlayerHuman(String name) {
        super(name);
    }

    @Override
    public String displayParametersAndGetChoice(Card topCard){
        View.display(topCard.toString());
        View.printParametersToChoose(topCard.getParametersKeys());
        View.clearScreen();
        String userInput = View.getUserInput();
        String userChoice = handleUserChoice(userInput);
        return userChoice;
    }
}

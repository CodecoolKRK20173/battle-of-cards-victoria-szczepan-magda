package main.java;

import java.util.Random;

public class AIPlayer extends Player {

    public AIPlayer() {
        super("AI player");
    }

    @Override
    public String displayParametersAndGetChoice(Card topCard){
        String AIChoice = chooseParameter();
        String AIParameter = handleUserChoice(AIChoice);
        return AIParameter;
    }

    private String chooseParameter() {
        Random random = new Random();
        return String.valueOf(random.nextInt(3) + 1);
    }

}

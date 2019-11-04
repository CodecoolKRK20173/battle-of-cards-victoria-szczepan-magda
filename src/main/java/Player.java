package main.java;

public abstract class Player {

    public abstract Hand getHand();

    public abstract void addPoints(int pointsAmount);

    public abstract int getPoints();

    public abstract String getName();

}

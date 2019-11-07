package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class View {

    public static void displayMenu() {
        System.out.println("Please, choose mode of the game: ");
        System.out.println("1. Player vs Computer mode");
        System.out.println("2. Multi player mode");
        System.out.println("3. Exit");
    }

    public static void display(String message){
        System.out.print(message);
    }

    public static String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        String[] options = {"1","2","3"};
        String input;
        do{
            System.out.println("Please enter 1, 2 or 3");
            input = scanner.nextLine();
        } while (!Arrays.asList(options).contains(input));
        return input;
    }

    public static void printParametersToChoose(List<String> parameterList){
        System.out.println("Choose parameter from the list:");
        for(int i = 0; i < parameterList.size(); i++){
            System.out.println(i+1 + ". " + parameterList.get(i));
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void displayPoints(Player player1, Player player2){
        String player1Points = String.valueOf(player1.getPoints());
        String player2Points = String.valueOf(player2.getPoints());
        System.out.print("player1 points: " + player1Points + "\n");
        System.out.print("player2 points: " + player2Points + "\n");

    }

}

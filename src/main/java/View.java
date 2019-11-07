package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class View {

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

}

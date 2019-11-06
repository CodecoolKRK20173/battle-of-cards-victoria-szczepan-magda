package main.java;

import java.util.List;
import java.util.Scanner;

public class View {

    public static void display(String message){
        System.out.print(message);
    }

    public static String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        String input;
        do{
            System.out.println("Please enter 1, 2 or 3");
            input = scanner.nextLine();
        } while (!input.equals("1") && !input.equals("2") && !input.equals("3"));
        return input;
    }

    public static void printParametersToChoose(List<String> parameterList){
        System.out.println("Choose parameter from the list:");
        for(int i = 0; i < parameterList.size(); i++){
            System.out.println(i+1 + ". " + parameterList.get(i));
        }
    }


}

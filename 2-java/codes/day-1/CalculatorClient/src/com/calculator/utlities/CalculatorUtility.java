package com.calculator.utlities;

import java.util.Scanner;

public class CalculatorUtility {

    public static void printMenu() {
        System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide");
    }

    public static int getChoice(Scanner scanner) {
        System.out.print("\nenter choice[1/2/3/4]: ");
        return scanner.nextInt();
    }

    public static int getValue(String message, Scanner scanner) {
        System.out.print("\nenter " + message + " value: ");
        return scanner.nextInt();
    }

    public static void displayResult(String resultString) {
        System.out.println("\n" + resultString);
    }

    public static char askForContinuation(Scanner scanner) {
        System.out.print("\nlike to continue[y/Y/n/N]? ");
        char temporary = scanner.next().charAt(0);
        if (!Character.isLowerCase(temporary))
            temporary = Character.toLowerCase(temporary);

        return temporary;
    }
}

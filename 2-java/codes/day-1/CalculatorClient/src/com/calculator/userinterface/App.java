package com.calculator.userinterface;

import com.calculator.services.CalculatorService;
import com.calculator.utlities.CalculatorUtility;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char toContinue = 'n';

        do {
            //1. print menu
            CalculatorUtility.printMenu();

            //2. get choice from user
            int operationChoice = CalculatorUtility.getChoice(scanner);

            //3. get values from user
            int firstValue = CalculatorUtility.getValue("first", scanner);
            int secondValue = CalculatorUtility.getValue("second", scanner);

            //4. perform the calculation
            CalculatorService calculatorService = new CalculatorService();
            String resultString = calculatorService.calculate(operationChoice, firstValue, secondValue);

            //5. display the result
            CalculatorUtility.displayResult(resultString);

            //6. ask user whether to continue or not
            toContinue = CalculatorUtility.askForContinuation(scanner);
        } while (toContinue != 'n');

        scanner.close();
    }
}

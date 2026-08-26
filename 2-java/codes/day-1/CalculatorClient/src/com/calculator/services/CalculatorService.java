package com.calculator.services;

import com.calculator.businesslogic.SimpleCalculator;

public class CalculatorService {

    public String calculate(int operationChoice, int firstValue, int secondValue) {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        String output;
        Integer res = null;
        switch (operationChoice) {
            case 1:
                res = simpleCalculator.add(firstValue, secondValue);
                output = "result of add is " + res;
                break;

            case 2:
                res = simpleCalculator.subtract(firstValue, secondValue);
                output = "result of subtract is " + res;
                break;

            case 3:
                res = simpleCalculator.multiply(firstValue, secondValue);
                output = "result of multiply is " + res;
                break;

            case 4:
                res = simpleCalculator.divide(firstValue, secondValue);
                output = "result of divide is " + res;
                break;

            default:
                output = "Invalid operation. result is " + (res == null ? "NA" : res.toString());
                break;
        }
        return output;
    }
}

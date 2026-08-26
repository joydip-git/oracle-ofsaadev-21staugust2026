package com.calculator.services;

import com.calculator.businesslogic.SimpleCalculator;

public class CalculatorService {

    public String calculate(int operationChoice, int firstValue, int secondValue) {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        String output;
        Integer res = null;
        output = switch (operationChoice) {
            case 1 -> {
                res = simpleCalculator.add(firstValue, secondValue);
                yield "result of add is " + res;
            }
            case 2 -> {
                res = simpleCalculator.subtract(firstValue, secondValue);
                yield "result of subtract is " + res;
            }
            case 3 -> {
                res = simpleCalculator.multiply(firstValue, secondValue);
                yield "result of multiply is " + res;
            }
            case 4 -> {
                res = simpleCalculator.divide(firstValue, secondValue);
                yield "result of divide is " + res;
            }
            default -> "Invalid operation. result is " + (res == null ? "NA" : res.toString());
        };
        return output;
    }
}

package com.payroll.utilities;

import com.payroll.entities.Developer;
import com.payroll.entities.Employee;
import com.payroll.entities.Hr;

import java.util.Scanner;

import static java.lang.System.*;

public class PayrollUIUtility {

    public static int getRecordCount(Scanner scanner) {
        out.print("enter number of records: ");
        return scanner.nextInt();
    }

    private static void printChoices() {
        out.println("\n1. Developer-> d\n2. Hr-> h");
    }

    private static char getChoice(Scanner scanner) {
        out.print("\nenter choice[d/h]: ");
        return scanner.next().charAt(0);
    }

    private static Employee create(char choice, Scanner scanner) {
        out.print("\nenter id: ");
        int id = scanner.nextInt();

        out.print("enter name: ");
        String name = scanner.next();

        out.print("enter basic: ");
        double basic = scanner.nextDouble();

        out.print("enter da: ");
        double da = scanner.nextDouble();

        out.print("enter hra: ");
        double hra = scanner.nextDouble();

        return switch (choice) {
            case 'd' -> {
                out.print("enter incentive: ");
                double incentive = scanner.nextDouble();
                yield new Developer(id, name, basic, da, hra, incentive);
            }
            case 'h' -> {
                out.print("enter gratuity: ");
                double gratuity = scanner.nextDouble();
                yield new Hr(id, name, basic, da, hra, gratuity);
            }
            default -> {
                yield null;
            }
        };
    }

    public static void createAndSaveEmployee(Employee[] employees,
                                             Scanner scanner) {
        for (int index = 0; index < employees.length; index++) {
            printChoices();
            char choice = getChoice(scanner);
            employees[index] = create(choice, scanner);
        }
    }

    public static void printSalary(Employee[] employees) {
        out.println("\n---Salary Slips---\n");
        for (var employee : employees) {
            if (employee != null) {
                employee.calculateSalary();
                out.println("Salary of " + employee.getName() + " is " + employee.getTotalSalary());
            }
        }
    }
}

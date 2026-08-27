package com.payroll.userinterface;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import com.payroll.entities.Employee;
import com.payroll.utilities.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("\t---Welcome to Payroll App---\n");

        //opening resource
        Scanner scanner = new Scanner(System.in);

        //asking user for number of objects to create
        int count = PayrollUIUtility.getRecordCount(scanner);

        //creating a storage
        Employee[] employees = new Employee[count];

        //creating individual objects and saving the same in the storage
        PayrollUIUtility.createAndSaveEmployee(employees, scanner);

        //calculating and printing the salary of every employee
        PayrollUIUtility.printSalary(employees);

        //closing resource
        scanner.close();
    }
}
package com.payroll.entities;

public class Employee {
    private int id;
    private String name;
    private double basicPayment;
    private double daPayment;
    private double hraPayment;
    private double totalSalary;

    public Employee() {
    }

    public Employee(int id,
                    String name,
                    double basicPayment,
                    double daPayment,
                    double hraPayment) {
        this.id = id;
        this.name = name;
        this.basicPayment = basicPayment;
        this.daPayment = daPayment;
        this.hraPayment = hraPayment;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public double getDaPayment() {
        return daPayment;
    }

    public void setDaPayment(double daPayment) {
        this.daPayment = daPayment;
    }

    public double getHraPayment() {
        return hraPayment;
    }

    public void setHraPayment(double hraPayment) {
        this.hraPayment = hraPayment;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    protected void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public void calculateSalary() {
        this.totalSalary = this.basicPayment + this.daPayment + this.hraPayment;
    }
}

package com.outstandingapp.entities;

public class Student extends Person {
    private double marks;

    public Student(double marks) {
        this.marks = marks;
    }

    public Student(String name, double marks) {
        super(name);
        this.marks = marks;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public final boolean isOutstanding() {
        return marks >= 85;
    }

    @Override
    public String toString() {
        return super.toString() + ", Marks=" + marks;
    }
}

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

    @Override
    public int hashCode() {
        return super.hashCode() * (int) marks;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        Student student = (Student) obj;
        return this.marks == student.marks;
    }

//    @Override
//    public int compareTo(Person o) {
//        if (o == null)
//            return 0;
//        if (o instanceof Student) {
//            if (this.getName().compareTo(o.getName()) == 0)
//                return Double.compare(this.marks, ((Student) o).marks);
//                //return (int)(this.marks - ((Student) o).marks);
//            else
//                return this.getName().compareTo(o.getName());
//        }
//        return -1;
//    }
}

package com.outstandingapp.userinterface;

import com.outstandingapp.entities.Person;
import com.outstandingapp.entities.PersonComparator;
import com.outstandingapp.entities.Professor;
import com.outstandingapp.entities.Student;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        Person[] people = new Person[]{
//                new Professor("anil", 4),
//                new Student("mahesh", 89),
//                new Professor("sunil", 6),
//                new Student("suresh", 78),
//        };
        PersonComparator comparator = new PersonComparator(2);
        Set<Person> people = new TreeSet<>(comparator);
        people.add(new Student("suresh", 78));
        people.add(new Student("anil", 89));
        people.add(new Professor("mahesh", 6));
        //people.add(new Professor("anil", 6));
        people.add(new Professor("sunil", 4));

        for (var p : people) {
//            if (p.isOutstanding()) {
//                if (p instanceof Professor) {
//                    Professor professor = (Professor) p;
//                    System.out.println(professor.getName() + ", " + professor.getBooksPublished());
//                }
//                if (p instanceof Student student) {
//                    System.out.println(student.getName() + ", " + student.getMarks());
//                }
//            }
            //if (p.isOutstanding())
            System.out.println(p);
        }
    }
}
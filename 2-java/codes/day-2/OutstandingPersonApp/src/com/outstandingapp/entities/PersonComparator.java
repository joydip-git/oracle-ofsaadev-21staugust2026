package com.outstandingapp.entities;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    private final int choice;

    public PersonComparator(int choice) {
        this.choice = choice;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return switch (choice) {
            case 1 -> {
                yield o1.getName().compareTo(o2.getName());
            }
            case 2 -> {
                if ((o1 instanceof Professor) && (o2 instanceof Professor)) {
                    yield ((Professor) o1).getBooksPublished() - ((Professor) o2).getBooksPublished();
                }
                if ((o1 instanceof Student) && (o2 instanceof Student)) {
                    yield Double.compare(((Student) o1).getMarks(), ((Student) o2).getMarks());
                }
                yield 0;
            }
            default -> o1.getName().compareTo(o2.getName());
        };
    }
}

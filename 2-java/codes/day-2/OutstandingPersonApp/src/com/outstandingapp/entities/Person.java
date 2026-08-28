package com.outstandingapp.entities;

public abstract class Person //implements Comparable<Person>
{
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name=" + name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return name.hashCode() * prime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof Person other) {
            if (this == other)
                return true;
            return this.name.equals(other.name);
        } else
            return false;
    }

    public abstract boolean isOutstanding();
}

package com.outstandingapp.entities;

public class Professor extends Person {
    private int booksPublished;

    public Professor(int booksPublished) {
        this.booksPublished = booksPublished;
    }

    public Professor(String name, int booksPublished) {
        super(name);
        this.booksPublished = booksPublished;
    }

    public int getBooksPublished() {
        return booksPublished;
    }

    public void setBooksPublished(int booksPublished) {
        this.booksPublished = booksPublished;
    }

    @Override
    public final boolean isOutstanding() {
        return booksPublished >= 5;
    }

    @Override
    public String toString() {
        return super.toString() + ", Books published=" + booksPublished;
        //return this.getClass().getCanonicalName()+"@"+this.hashCode();
    }
}

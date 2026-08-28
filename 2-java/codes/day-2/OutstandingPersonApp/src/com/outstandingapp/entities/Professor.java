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

    @Override
    public int hashCode() {
        return super.hashCode() * booksPublished;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        Professor professor = (Professor) obj;
        return this.booksPublished == professor.booksPublished;
    }

//    @Override
//    public int compareTo(Person o) {
//        if (o == null)
//            return 0;
//
//        if(o instanceof  Professor ) {
//            if (this.getName().compareTo(o.getName()) == 0)
//                return Integer.compare(this.booksPublished, ((Professor) o).booksPublished);
//                //return  (this.booksPublished - ((Professor) o).booksPublished);
//            else
//                return this.getName().compareTo(o.getName());
//        }
//        return  1;
//    }
}

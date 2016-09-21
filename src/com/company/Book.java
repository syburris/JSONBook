package com.company;

/**
 * Created by stevenburris on 9/21/16.
 */
public class Book {
    String name;
    String author;
    String publisher;
    int yearPublished;
    boolean enjoyedReading;

    Book() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public boolean isEnjoyedReading() {
        return enjoyedReading;
    }

    public void setEnjoyedReading(boolean enjoyedReading) {
        this.enjoyedReading = enjoyedReading;
    }
}

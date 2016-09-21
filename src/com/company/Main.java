package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();

        System.out.println("What is the book's name?");
        String bookName = scanner.nextLine();
        if (bookName == null) {
            System.out.println("You have to have read something, start over.");
            main(args);
        }
        System.out.println("What is the book's author?");
        String bookAuthor = scanner.nextLine();
        if (bookAuthor == null) {
            System.out.printf("%s has to have an author, begin again.\n", bookName);
            main(args);
        }
        else {
            book.author = bookAuthor;
        }
        System.out.println("What is the book's publisher?");
        String bookPublisher = scanner.nextLine();
        if (bookPublisher == null) {
            System.out.printf("%s had to have been published, begin again.\n", bookName);
        }
        else {
            book.publisher = bookPublisher;
        }
        System.out.println("What year was the book published?");
        String yearPublished = scanner.nextLine();
        if (yearPublished == null) {
            System.out.printf("%s had to have been published sometime, start over.\n", bookName);
        }
        else {
            book.yearPublished = Integer.valueOf(yearPublished);
        }
        System.out.println("Did you enjoy reading the book? Type yes or no.");
        String enjoyedRead = scanner.nextLine();
        if (enjoyedRead.equalsIgnoreCase("yes")) {
            book.enjoyedReading = true;
        }
        else if (enjoyedRead.equalsIgnoreCase("no")) {
            book.enjoyedReading = false;
        }
        else {
            System.out.println("Everyone has an opinion, start over.");
            main(args);
        }
        System.out.println(book.author);


    }
}

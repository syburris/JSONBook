package com.company;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

    static final String BOOK = "book.json";
    static Book book = new Book();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("This is your current book information:");
        System.out.println();
        read();
        System.out.println();
        System.out.println();
        System.out.println("Would you like to update your book information?");
        System.out.println("Enter yes to update, or no to save the current information.");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("What is the book's title?");
            String bookTitle = scanner.nextLine();
            if (bookTitle == null) {
                System.out.println("You have to have read something, start over.");
                main(args);
            }
            else {
                book.title = bookTitle;
            }
            System.out.println("Who is the book's author?");
            String bookAuthor = scanner.nextLine();
            if (bookAuthor == null) {
                System.out.printf("%s has to have an author, begin again.\n", bookTitle);
                main(args);
            }
            else {
                book.author = bookAuthor;
            }
            System.out.println("What company published the book?");
            String bookPublisher = scanner.nextLine();
            if (bookPublisher == null) {
                System.out.printf("%s had to have been published, begin again.\n", bookTitle);
            }
            else {
                book.publisher = bookPublisher;
            }
            System.out.println("What year was the book published?");
            String yearPublished = scanner.nextLine();
            if (yearPublished == null) {
                System.out.printf("%s had to have been published sometime, start over.\n", bookTitle);
            }
            else {
                book.yearPublished = Integer.valueOf(yearPublished);
            }
            System.out.printf("What genre is %s?\n",bookTitle);
            String bookGenre = scanner.nextLine();
            if (bookGenre.isEmpty()) {
                System.out.println("Every book has a genre, start over.");
            }
            else {
                book.genre = bookGenre;
            }
            write();
            main(args);
        }
        if (answer.equalsIgnoreCase("no")){
            System.out.printf("%s's information has not been changed.\n", book.title);
            System.out.println("Have a good one....");
            System.exit(0);
        }
        else {
            System.out.println("Your response was invalid, try again");
            main(args);
        }


    }
    static void write(){
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.deep(true).serialize(book);
        File f = new File(BOOK);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (Exception e) {
            System.out.println("Couldn't save your book's information!");
        }
    }
    static void read() {
        File f = new File(BOOK);
        try {
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] contents = new char[fileSize];
            fr.read(contents, 0, fileSize);
            JsonParser parser = new JsonParser();
            Book b2 = parser.parse(contents, Book.class);
            System.out.printf("%s is the title of the book.\n", b2.title);
            System.out.printf("%s is the author of the book.\n", b2.author);
            System.out.printf("%s is the publisher of the book.\n", b2.publisher);
            System.out.printf("%s is the year this book was published.\n", b2.yearPublished);
            System.out.printf("%s is classified as %s",b2.title,b2.genre);

        }
        catch (Exception e) {
            System.out.println("Couldn't load your book!");
        }
    }


}

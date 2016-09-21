package com.company;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

    static final String BOOK = "/com.company/book.json";
    static Book book = new Book();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



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
    static void write(){
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(book);
        File f = new File(BOOK);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (Exception e) {
            System.out.println("Couldn't save to file!");
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
            book = parser.parse(contents, Book.class);
        }
        catch (Exception e) {
            System.out.println("Couldn't load file!");
        }
    }


}

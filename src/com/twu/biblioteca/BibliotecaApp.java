package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    List<String> books;

    public BibliotecaApp() {
        books = new ArrayList<>();
        books.add("Harry Potter and The Sorcer\'s Stone");
        books.add("Harry Potter and The Chamber of Secrets");
    }

    public static void main(String[] args) {

    }

    public void welcomeMessage() {
        System.out.println("Welcome to Biblioteca");
    }

    public void displayBooks() {
        for(String book : books) {
            System.out.println(book);
        }
    }
}
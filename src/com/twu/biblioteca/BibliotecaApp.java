package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    List<String[]> books;

    public BibliotecaApp() {
        books = new ArrayList<>();
        books.add(new String[]{"Harry Potter and The Sorcer\'s Stone", "J. K. Rowling", "2000"});
        books.add(new String[]{"Harry Potter and The Chamber of Secrets", "J. K. Rowling", "2001"});
    }

    public void welcomeMessage() {
        System.out.println("Welcome to Biblioteca");
    }

    public void displayBooks() {
        StringBuilder sb = new StringBuilder();
        for (String[] book : books) {
            sb.append(book[0]).append(", ").append(book[1]).append(", ").append(book[2]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.welcomeMessage();
        bibliotecaApp.displayBooks();
    }
}
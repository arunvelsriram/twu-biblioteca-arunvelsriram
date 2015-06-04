package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {
    private Library library;

    public BibliotecaApp(Library library) {
        this.library = library;
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new Library());
        System.out.println(bibliotecaApp.welcomeMessage());
        bibliotecaApp.displayBooks();
    }

    private void displayBooks() {
        List<Book> books = library.getBooks();
        for(Book book : books) {
            System.out.println(book.getName());
        }
    }

    public String welcomeMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to Biblioteca - A Library Management System\n");
        int length = sb.length();
        for (int i = 0; i < length; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
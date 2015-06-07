package com.twu.biblioteca;

public class OutputHandler {
    public void welcomeMessage() {
        System.out.println("***Welcome to Biblioteca***");
    }

    public void bookDetails(Books books) {
        System.out.println(books);
    }

    public void listOptions(Menu menu) {
        System.out.print(menu);
    }
}
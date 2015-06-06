package com.twu.biblioteca;

public class BibliotecaApp {
    private OutputHandler outputHandler;

    public BibliotecaApp(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public void start() {
        outputHandler.welcomeMessage();
        Books books = new Books();
        outputHandler.bookDetails(books);
    }

    public static void main(String[] args) {
    }
}
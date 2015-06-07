package com.twu.biblioteca;

public class BibliotecaApp {
    private OutputHandler outputHandler;

    public BibliotecaApp(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public void start() {
        outputHandler.welcomeMessage();
        Menu menu = new Menu();
        outputHandler.listOptions(menu);
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new OutputHandler());
        bibliotecaApp.start();
    }
}
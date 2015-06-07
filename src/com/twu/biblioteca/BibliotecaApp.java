package com.twu.biblioteca;

public class BibliotecaApp {
    private InputOutputHandler inputOutputHandler;

    public BibliotecaApp(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void start() {
        inputOutputHandler.welcomeMessage();
        Menu menu = new Menu();
        inputOutputHandler.listOptions(menu);
        int option = inputOutputHandler.readMenuOption();
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new InputOutputHandler());
        bibliotecaApp.start();
    }
}
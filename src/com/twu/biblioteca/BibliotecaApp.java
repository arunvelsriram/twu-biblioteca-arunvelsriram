package com.twu.biblioteca;

public class BibliotecaApp {
    private InputOutputHandler inputOutputHandler;

    public BibliotecaApp(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void start() {
        inputOutputHandler.welcomeMessage();
        MenuItemActionListener menuItemActionListener = new MenuItemActionListenerImpl();
        Menu menu = new Menu(menuItemActionListener);
        inputOutputHandler.listOptions(menu);
        int option = inputOutputHandler.readMenuOption();
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new InputOutputHandler());
        bibliotecaApp.start();
    }
}
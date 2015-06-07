package com.twu.biblioteca;

public class BibliotecaApp {
    private FactoryHelper factoryHelper;

    public static class FactoryHelper {
        public Menu makeMenu() {
            return new Menu(new MenuItemActionListenerImpl());
        }

        public InputOutputHandler makeInputOutputHandler() {
            return new InputOutputHandler();
        }
    }

    public BibliotecaApp() {
        this(new FactoryHelper());
    }

    public BibliotecaApp(FactoryHelper factoryHelper) {
        this.factoryHelper = factoryHelper;
    }

    public void start() {
        InputOutputHandler inputOutputHandler = factoryHelper.makeInputOutputHandler();
        inputOutputHandler.welcomeMessage();
        Menu menu = factoryHelper.makeMenu();
        inputOutputHandler.listOptions(menu);
        int option = inputOutputHandler.readMenuOption();
        menu.choose(option);
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }
}
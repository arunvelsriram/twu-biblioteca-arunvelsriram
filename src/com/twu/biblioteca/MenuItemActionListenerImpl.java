package com.twu.biblioteca;

public class MenuItemActionListenerImpl implements MenuItemActionListener {
    public static class FactoryHelper {
        public InputOutputHandler makeInputOutputHandler() {
            return new InputOutputHandler();
        }

        public Books makeBooks() {
            return new Books();
        }
    }

    private FactoryHelper factoryHelper;

    public MenuItemActionListenerImpl() {
        this(new FactoryHelper());
    }

    public MenuItemActionListenerImpl(FactoryHelper factoryHelper) {
        this.factoryHelper = factoryHelper;
    }

    @Override
    public void actionPerformed(int option) {
        InputOutputHandler inputOutputHandler = factoryHelper.makeInputOutputHandler();
        if (option == 1) {
            Books books = factoryHelper.makeBooks();
            inputOutputHandler.bookDetails(books);
        } else {
            inputOutputHandler.errorMessage();
        }
    }
}
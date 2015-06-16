package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.BooksController;

public class ReturnBookAction implements MenuItemAction {
    private BooksController booksController;

    public ReturnBookAction(BooksController booksController) {
        this.booksController = booksController;
    }

    @Override
    public void performAction() {
        booksController.returnBook();
    }
}
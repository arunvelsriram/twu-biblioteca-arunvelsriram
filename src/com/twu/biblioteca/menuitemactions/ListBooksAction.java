package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.BooksController;

public class ListBooksAction implements MenuItemAction {

    private BooksController booksController;

    public ListBooksAction(BooksController booksController) {
        this.booksController = booksController;
    }

    @Override
    public void performAction() {
        booksController.listBooks();
    }
}
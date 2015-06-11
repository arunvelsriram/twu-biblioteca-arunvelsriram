package com.twu.biblioteca;

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
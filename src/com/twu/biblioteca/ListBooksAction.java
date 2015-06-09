package com.twu.biblioteca;

public class ListBooksAction implements MenuItemAction {
    private BooksView booksView;

    public ListBooksAction(BooksView booksView) {
        this.booksView = booksView;
    }

    @Override
    public void performAction() {
        booksView.display();
    }
}
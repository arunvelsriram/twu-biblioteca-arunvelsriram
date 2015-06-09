package com.twu.biblioteca;

import com.twu.biblioteca.views.BooksView;

public class ListBooksAction implements MenuItemAction {
    private BooksView booksView;

    public ListBooksAction(BooksView booksView) {
        this.booksView = booksView;
    }

    @Override
    public void performAction() {
        booksView.write();
    }
}
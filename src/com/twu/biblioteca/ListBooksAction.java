package com.twu.biblioteca;

public class ListBooksAction implements MenuItemAction {

    private final View view;
    private Books books;

    public ListBooksAction(View view, Books books) {
        this.view = view;
        this.books = books;
    }

    @Override
    public void performAction() {
        view.write(books.toString());
    }
}
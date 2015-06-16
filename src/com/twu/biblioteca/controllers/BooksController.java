package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.views.View;

public class BooksController {
    private Library library;
    private View view;

    public BooksController(Library library, View view) {
        this.library = library;
        this.view = view;
    }

    public void listAvailableBooks() {
        String bookDetails = library.availableBooks();
        view.write(bookDetails);
    }

    public void checkoutABook() {
        String title = view.read();
        String message = library.checkoutBook(title);
        view.write(message);
    }

    public void returnABook() {
        String title = view.read();
        String message = library.returnBook(title);
        view.write(message);
    }
}
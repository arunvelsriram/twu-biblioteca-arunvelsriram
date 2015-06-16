package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.views.View;

public class BooksController {
    private Books books;
    private View view;

    public BooksController(Books books, View view) {
        this.books = books;
        this.view = view;
    }

    public void listAvailableBooks() {
        String bookDetails = books.availableBooks();
        view.write(bookDetails);
    }

    public void checkoutABook() {
        String title = view.read();
        String message = books.checkoutBook(title);
        view.write(message);
    }

    public void returnABook() {
        String title = view.read();
        String message = books.returnBook(title);
        view.write(message);
    }
}
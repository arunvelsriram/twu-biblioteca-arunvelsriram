package com.twu.biblioteca;

import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.view.View;

public class BooksController {
    private Books books;
    private View view;

    public BooksController(Books books, View view) {
        this.books = books;
        this.view = view;
    }

    public void listBooks() {
        String bookDetails = books.toString();
        view.write(bookDetails);
    }
}
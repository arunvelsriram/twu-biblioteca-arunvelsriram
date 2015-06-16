package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.views.View;

public class BooksController {
    private Section section;
    private View view;

    public BooksController(Section section, View view) {
        this.section = section;
        this.view = view;
    }

    public void listAvailableBooks() {
        String bookDetails = section.availableBooks();
        view.write(bookDetails);
    }

    public void checkoutABook() {
        String title = view.read();
        String message = section.checkoutBook(title);
        view.write(message);
    }

    public void returnABook() {
        String title = view.read();
        String message = section.returnBook(title);
        view.write(message);
    }
}
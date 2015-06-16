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
        String bookDetails = section.availableItems();
        view.write(bookDetails);
    }

    public void checkoutABook() {
        String title = view.read();
        if(section.checkoutItem(title)) {
            view.write("Thank you! Enjoy the book.");
        }
        else {
            view.write("That book is not available.");
        }
    }

    public void returnABook() {
        String title = view.read();
        if(section.returnItem(title)) {
            view.write("Thank you for returning the book.");
        }
        else {
            view.write("That is not a valid book to return.");
        }
    }
}
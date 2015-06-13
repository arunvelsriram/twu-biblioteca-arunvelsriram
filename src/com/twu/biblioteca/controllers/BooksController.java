package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.views.View;

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

    public void checkoutBook() {
        Book book = getBook();
        if (books.checkOut(book)) {
            view.write("Thank you! Enjoy the book!");
        } else {
            view.write("That book is not available!");
        }
    }

    public void returnBook() {
        Book book = getBook();
        if (book != null) {
            books.returnBook(book);
            view.write("Thank you for returning the book.");
        } else {
            view.write("That is not a valid book to return.");
        }
    }

    private Book getBook() {
        String title = view.read();
        return books.search(title);
    }
}
package com.twu.biblioteca;

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
        String title = view.read();
        Book book = books.book(title);
        if (book != null) {
            books.remove(book);
            view.write("Thank you! Enjoy the book!");
        } else {
            view.write("That book is not available!");
        }
    }
}
package com.twu.biblioteca.views;

import com.twu.biblioteca.Books;

public class BooksView {
    private Books books;

    public BooksView(Books books) {
        this.books = books;
    }

    public void write() {
        System.out.println(books);
    }
}
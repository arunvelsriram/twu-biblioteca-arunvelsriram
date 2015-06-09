package com.twu.biblioteca;

public class BooksView {
    private Books books;

    public BooksView(Books books) {
        this.books = books;
    }

    public void display() {
        System.out.println(books);
    }
}
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
        books.add(new Book("Harry Potter and The Sorcerers Stone"));
        books.add(new Book("Harry Potter and The Chamber of Secret"));
    }

    public List<Book> getBooks() {
        return books;
    }
}

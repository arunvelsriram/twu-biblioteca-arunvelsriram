package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<Book> books;

    public Books() {
        books = new ArrayList<>();
        books.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        books.add(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
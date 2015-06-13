package com.twu.biblioteca.models;

import java.util.Map;

public class Books {
    private Map<Book, Boolean> books;

    public Books(Map<Book, Boolean> books) {
        this.books = books;
    }

    public Book search(String title) {
        for(Map.Entry<Book, Boolean> entry : books.entrySet()) {
            Book book = entry.getKey();
            Boolean isAvailable = entry.getValue();
            if(book.match(title) && isAvailable) {
                return book;
            }
        }
        return null;
    }

    public void remove(Book book) {
        books.remove(book);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books.keySet()) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }
}
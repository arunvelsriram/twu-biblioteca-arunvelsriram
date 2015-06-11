package com.twu.biblioteca.models;

import java.util.List;

public class Books {
    private List<Book> books;

    public Books(List<Book> books) {
        this.books = books;
    }

    public Book book(String title) {
        for(Book book : books) {
            if(book.exist(title)) {
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
        for (Book book : books) {
            sb.append(book).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
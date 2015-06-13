package com.twu.biblioteca.models;

import java.util.Map;

public class Books {
    private Map<Book, Boolean> books;

    public Books(Map<Book, Boolean> books) {
        this.books = books;
    }

    public Book search(String title) {
        for (Map.Entry<Book, Boolean> entry : books.entrySet()) {
            Book book = entry.getKey();
            if (book.match(title)) {
                return book;
            }
        }
        return null;
    }

    public boolean checkOut(Book book) {
        if(book != null && books.containsKey(book) && books.get(book)) {
            books.put(book, false);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books.keySet()) {
            if (books.get(book)) {
                sb.append(book).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Books)) return false;

        Books otherBooks = (Books) o;

        return !(books != null ? !books.equals(otherBooks.books) : otherBooks.books != null);
    }

    @Override
    public int hashCode() {
        return books != null ? books.hashCode() : 0;
    }

    public void returnBook(Book book) {
        books.put(book, true);
    }
}
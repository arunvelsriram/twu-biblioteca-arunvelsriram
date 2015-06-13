package com.twu.biblioteca.models;

import java.util.Map;

public class Books {
    private Map<Book, Boolean> books;

    public Books(Map<Book, Boolean> books) {
        this.books = books;
    }

    public Book search(String title) {
        for (Map.Entry<Book, Boolean> entry : books.entrySet()) {
            if (bookIsAvailable(title, entry)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void checkOut(Book book) {
        books.put(book, false);
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

    private boolean bookIsAvailable(String title, Map.Entry<Book, Boolean> entry) {
        Book book = entry.getKey();
        Boolean checkedOut = entry.getValue();
        return book.match(title) && checkedOut;
    }
}
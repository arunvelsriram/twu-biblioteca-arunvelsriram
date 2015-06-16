package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<Book> issuedBooks;
    private List<Book> availableBooks;

    public Books(List<Book> availableBooks, List<Book> issuedBooks) {
        this.availableBooks = availableBooks;
        this.issuedBooks = issuedBooks;
    }

    public String availableBooks() {
        StringBuilder sb = new StringBuilder();
        for (Book book : availableBooks) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }

    public String checkoutBook(String title) {
        List<Book> result = search(title, availableBooks);
        for (Book book : result) {
            availableBooks.remove(book);
            issuedBooks.add(book);
            return "Thank you! Enjoy the book.";
        }
        return "That book is not available!";
    }

    public String returnBook(String title) {
        List<Book> result = search(title, issuedBooks);
        for (Book book : result) {
            issuedBooks.remove(book);
            availableBooks.add(book);
            return "Thank you for returning the book.";
        }
        return "That is not a valid book to return.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Books)) return false;

        Books books = (Books) o;

        if (!issuedBooks.equals(books.issuedBooks)) return false;
        return availableBooks.equals(books.availableBooks);

    }

    @Override
    public int hashCode() {
        int result = issuedBooks.hashCode();
        result = 31 * result + availableBooks.hashCode();
        return result;
    }

    private List<Book> search(String title, List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.match(title)) {
                result.add(book);
            }
        }
        return result;
    }
}

package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<String> books;

    public Books() {
        books = new ArrayList<>();
        books.add("Harry Potter and The Sorcer's Stone");
        books.add("Harry Potter and The Chamber of Secrets");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Books otherBooks = (Books) object;

        return !(books != null ? !books.equals(otherBooks.books) : otherBooks.books != null);
    }

    @Override
    public int hashCode() {
        return books != null ? books.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String book : books) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }
}
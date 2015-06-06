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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String book : books) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }
}
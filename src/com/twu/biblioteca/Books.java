package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<String[]> books;

    public Books() {
        books = new ArrayList<>();
        books.add(new String[]{"Harry Potter and The Sorcer's Stone", "JK Rowling", "1999"});
        books.add(new String[]{"Harry Potter and The Chamber of Secrets", "JK Rowling", "2000"});
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String[] bookDetails : books) {
            sb.append("| ");
            for(String bookDetail : bookDetails) {
                sb.append(bookDetail).append(" | ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
package com.twu.biblioteca.models;

public class Book {
    private String title;
    private String author;
    private int yearOfPublication;

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("| ")
                .append(title)
                .append(" | ")
                .append(author)
                .append(" | ")
                .append(yearOfPublication)
                .append(" |");
        return sb.toString();
    }
}
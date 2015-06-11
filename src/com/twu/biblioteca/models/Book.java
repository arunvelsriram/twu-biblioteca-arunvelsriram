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

    public boolean exists(String title) {
        return this.title.equals(title);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (yearOfPublication != book.yearOfPublication) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        return !(author != null ? !author.equals(book.author) : book.author != null);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + yearOfPublication;
        return result;
    }
}
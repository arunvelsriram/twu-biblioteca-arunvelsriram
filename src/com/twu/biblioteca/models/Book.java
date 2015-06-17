package com.twu.biblioteca.models;

public class Book implements Item {
    private String name;
    private String author;
    private int yearOfPublication;


    public Book(String name, String author, int yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public boolean match(String title) {
        return this.name.equals(title);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("| ")
                .append(name)
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
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        return !(author != null ? !author.equals(book.author) : book.author != null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + yearOfPublication;
        return result;
    }
}
package com.twu.biblioteca.models;

public class Movie implements Item {
    private String name;
    private String directorName;
    private int year;
    private int rating;

    public Movie(String name, String directorName, int year, int rating) {
        this.name = name;
        this.directorName = directorName;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public boolean match(String name) {
        return name.equals(this.name);
    }
}
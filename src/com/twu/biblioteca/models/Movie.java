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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;

        Movie movie = (Movie) o;

        if (year != movie.year) return false;
        if (rating != movie.rating) return false;
        if (!name.equals(movie.name)) return false;
        return directorName.equals(movie.directorName);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + directorName.hashCode();
        result = 31 * result + year;
        result = 31 * result + rating;
        return result;
    }
}
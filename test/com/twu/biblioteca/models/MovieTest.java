package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieTest {
    @Test
    public void shouldReturnTrueWhenABooksTitleMatchesWithTheGivenTitle() throws Exception {
        Movie movie = new Movie("The Prestige", "Christopher Nolan", 2006, 10);

        assertTrue(movie.match("The Prestige"));
    }

    @Test
    public void shouldReturnFalseWhenABooksTitleDoesNotMatchTheGivenTitle() throws Exception {
        Movie movie= new Movie("The Dark Knight", "Christopher Nolan", 1999, 10);

        assertFalse(movie.match("Twilight"));
    }
}
package com.twu.biblioteca.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MovieTest {
    @Test
    public void shouldReturnTrueWhenABooksTitleMatchesWithTheGivenTitle() {
        Movie movie = new Movie("The Prestige", "Christopher Nolan", 2006, "10");

        assertTrue(movie.match("The Prestige"));
    }

    @Test
    public void shouldReturnFalseWhenABooksTitleDoesNotMatchTheGivenTitle() {
        Movie movie = new Movie("The Dark Knight", "Christopher Nolan", 1999, "10");

        assertFalse(movie.match("Twilight"));
    }

    @Test
    public void equalityShouldSatisfyReflexivity() {
        Movie movieOne = new Movie("The Prestige", "Christopher Nolan", 2006, "10");

        assertThat(movieOne, is(equalTo(movieOne)));
    }

    @Test
    public void equalityShouldSatisfySymmetricity() {
        Movie movieOne = new Movie("The Prestige", "Christopher Nolan", 2006, "10");
        Movie movieTwo = new Movie("The Prestige", "Christopher Nolan", 2006, "10");

        assertThat(movieOne, is(equalTo(movieTwo)));
        assertThat(movieTwo, is(equalTo(movieOne)));
    }

    @Test
    public void equalityShouldSatisfyTransitivity() {
        Movie movieOne = new Movie("The Prestige", "Christopher Nolan", 2006, "10");
        Movie movieTwo = new Movie("The Prestige", "Christopher Nolan", 2006, "10");
        Movie movieThree = new Movie("The Prestige", "Christopher Nolan", 2006, "10");

        assertThat(movieOne, is(equalTo(movieTwo)));
        assertThat(movieTwo, is(equalTo(movieThree)));
        assertThat(movieOne, is(equalTo(movieThree)));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingNull() {
        Movie movieOne = new Movie("The Prestige", "Christopher Nolan", 2006, "10");

        assertFalse(movieOne.equals(null));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingOtherObject() {
        Movie movieOne = new Movie("The Prestige", "Christopher Nolan", 2006, "10");

        assertFalse(movieOne.equals(new String("Hello, World")));
    }

    @Test
    public void whenTwoObjectsAreEqualThenTheirHashCodeMustBeEqual() {
        Movie movieOne = new Movie("The Prestige", "Christopher Nolan", 2006, "10");
        Movie movieTwo = new Movie("The Prestige", "Christopher Nolan", 2006, "10");

        assertThat(movieOne, is(equalTo(movieTwo)));
        assertThat(movieOne.hashCode(), is(equalTo(movieTwo.hashCode())));
    }

    @Test
    public void shouldBeAbleToReturnTheMovieDetails() {
        Movie movie = new Movie("The Prestige", "Christopher Nolan", 2006, "10");

        String actualBook = movie.toString();

        assertThat(actualBook, is(equalTo("| The Prestige | Christopher Nolan | 2006 | 10 |")));
    }
}
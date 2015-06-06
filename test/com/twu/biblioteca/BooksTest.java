package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BooksTest {
    @Test
    public void shouldBeAbleToReturnBookDetails() {
        Books books = new Books();

        String actualBookDetails = books.toString();

        assertThat(actualBookDetails, is(equalTo("Harry Potter and The Sorcer's Stone\nHarry Potter and The Chamber of Secrets\n")));
    }

    @Test
    public void equalityShouldSatisfyReflexivity() {
        Books books = new Books();

        assertThat(books, is(equalTo(books)));
    }

    @Test
    public void equalityShouldSatisfySymmetricity() {
        Books firstListOfBooks = new Books();
        Books secondListOfBooks = new Books();

        assertThat(firstListOfBooks, is(equalTo(secondListOfBooks)));
        assertThat(secondListOfBooks, is(equalTo(firstListOfBooks)));
    }

    @Test
    public void equalityShouldSatisfyTransitivity() {
        Books firstListOfBooks = new Books();
        Books secondListOfBooks = new Books();
        Books thirdListOfBooks = new Books();

        assertThat(firstListOfBooks, is(equalTo(secondListOfBooks)));
        assertThat(secondListOfBooks, is(equalTo(thirdListOfBooks)));
        assertThat(firstListOfBooks, is(equalTo(thirdListOfBooks)));
    }
}
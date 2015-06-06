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
}
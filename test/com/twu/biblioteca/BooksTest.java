package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BooksTest {
    private Books books;

    @Test
    public void shouldBeAbleToReturnBookDetails() throws Exception {
        books = new Books();

        String actualBookDetails = books.toString();

        assertThat(actualBookDetails, is(equalTo("Harry Potter and The Sorcer's Stone\nHarry Potter and The Chamber of Secrets\n")));
    }
}
package com.twu.biblioteca.models;

import com.twu.biblioteca.models.Book;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void shouldBeAbleToReturnBookDetail() throws Exception {
        Book book = new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999);

        String actualBook = book.toString();

        assertThat(actualBook, is(equalTo("| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |")));
    }
}
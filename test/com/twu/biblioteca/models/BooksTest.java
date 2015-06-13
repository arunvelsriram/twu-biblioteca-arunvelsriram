package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BooksTest {

    private Books books;

    @Before
    public void setUp() throws Exception {
        Map<Book, Boolean> availableBooks = new LinkedHashMap<>();
        availableBooks.put(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999), true);
        availableBooks.put(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000), true);
        books = new Books(availableBooks);
    }

    @Test
    public void shouldBeAbleToReturnBookDetails() {
        String actualBookDetails = books.toString();

        assertThat(actualBookDetails, is(equalTo("| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |\n" +
                "| Harry Potter and The Chamber of Secrets | JK Rowling | 2000 |\n")));
    }

    @Test
    public void shouldBeAbleToRetrieveABookUsingTheTitle() throws Exception {
        Book actualBook = books.search("Harry Potter and The Chamber of Secrets");

        assertThat(actualBook, is(equalTo(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000))));
    }

    @Test
    public void shouldReturnNullWhenABookDoesNotExist() throws Exception {
        Book actualBook = books.search("Twilight");

        assertThat(actualBook, is(equalTo(null)));
    }

    @Test
    public void shouldBeAbleToRemoveABookFromTheBookList() throws Exception {
        Book book = new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999);
        books.remove(book);

        assertThat(books.toString(), is(equalTo("| Harry Potter and The Chamber of Secrets | JK Rowling | 2000 |\n")));
    }
}
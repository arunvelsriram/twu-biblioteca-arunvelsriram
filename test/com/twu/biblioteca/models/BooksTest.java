package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BooksTest {

    private Books books;

    @Before
    public void setUp() throws Exception {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        bookList.add(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000));
        books = new Books(bookList);
    }

    @Test
    public void shouldBeAbleToReturnBookDetails() {
        String actualBookDetails = books.toString();

        assertThat(actualBookDetails, is(equalTo("| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |\n" +
                "| Harry Potter and The Chamber of Secrets | JK Rowling | 2000 |")));
    }

    @Test
    public void shouldBeAbleToRetrieveABookUsingTheTitle() throws Exception {
        Book actualBook = books.book("Harry Potter and The Chamber of Secrets");

        assertThat(actualBook, is(equalTo(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000))));
    }

    @Test
    public void shouldReturnNullWhenABookDoesNotExist() throws Exception {
        Book actualBook = books.book("Twilight");

        assertThat(actualBook, is(equalTo(null)));
    }

    @Test
    public void shouldBeAbleToRemoveABookFromTheBookList() throws Exception {
        Book book = new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999);
        books.remove(book);

        assertThat(books.toString(), is(equalTo("| Harry Potter and The Chamber of Secrets | JK Rowling | 2000 |")));
    }
}
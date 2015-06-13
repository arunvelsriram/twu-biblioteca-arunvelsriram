package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class BooksTest {

    private Books books;
    private Map<Book, Boolean> bookDetails;

    @Before
    public void setUp() throws Exception {
        bookDetails = new LinkedHashMap<>();
        bookDetails.put(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999), true);
        bookDetails.put(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000), true);
        books = new Books(bookDetails);
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
    public void equalityShouldSatisfyReflexivity() {
        Books booksOne = new Books(bookDetails);

        assertThat(booksOne, is(equalTo(booksOne)));
    }

    @Test
    public void equalityShouldSatisfySymmetricity() {
        Books booksOne = new Books(bookDetails);
        Books booksTwo = new Books(bookDetails);

        assertThat(booksOne, is(equalTo(booksTwo)));
        assertThat(booksTwo, is(equalTo(booksOne)));
    }

    @Test
    public void equalityShouldSatisfyTransitivity() {
        Books booksOne = new Books(bookDetails);
        Books booksTwo = new Books(bookDetails);
        Books booksThree = new Books(bookDetails);

        assertThat(booksOne, is(equalTo(booksTwo)));
        assertThat(booksTwo, is(equalTo(booksThree)));
        assertThat(booksOne, is(equalTo(booksThree)));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingNull() {
        Books booksOne = new Books(bookDetails);

        assertFalse(booksOne.equals(null));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingOtherObject() {
        Books booksOne = new Books(bookDetails);

        assertFalse(booksOne.equals(new String("Hello, World")));
    }

    @Test
    public void whenTwoObjectsAreEqualThenTheirHashCodeMustBeEqual() {
        Books booksOne = new Books(bookDetails);
        Books booksTwo = new Books(bookDetails);

        assertThat(booksOne, is(equalTo(booksTwo)));
        assertThat(booksOne.hashCode(), is(equalTo(booksTwo.hashCode())));
    }

    @Test
    public void shouldBeAbleToFlagABookOnCheckout() throws Exception {
        Map<Book, Boolean> expectedBookDetails = new LinkedHashMap<>();
        expectedBookDetails.put(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999), false);
        expectedBookDetails.put(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000), true);
        Books expectedBooks = new Books(expectedBookDetails);

        books.checkOut(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));

        assertThat(books, is(equalTo(expectedBooks)));
    }
}
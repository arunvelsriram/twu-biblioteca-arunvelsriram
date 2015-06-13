package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
    public void shouldReturnTrueOnSuccessfulCheckOut() throws Exception {
        boolean actual = books.checkOut(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));

        assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseOnUnSuccessfulCheckOutCausedByPassingAWrongBook() throws Exception {
        boolean actual = books.checkOut(new Book("Twilight", "Stephenie Meyer", 2002));

        assertFalse(actual);
    }

    @Test
    public void shouldReturnFalseOnUnSuccessfulCheckOutCausedByPassingNull() throws Exception {
        boolean actual = books.checkOut(null);

        assertFalse(actual);
    }

    @Test
    public void shouldReturnFalseOnUnSuccessfulCheckOutCausedByPassingABookThatIsAlreadyIssued() throws Exception {
        Map<Book, Boolean> bookDetails = new LinkedHashMap<>();
        bookDetails.put(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000), false);
        books = new Books(bookDetails);

        boolean actual = books.checkOut(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000));

        assertFalse(actual);
    }
}
package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class BooksTest {

    private Books books;
    private List<Book> availableBooks;
    private List<Book> issuedBooks;

    @Before
    public void setUp() throws Exception {
        availableBooks = new ArrayList<>();
        availableBooks.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        availableBooks.add(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000));
        issuedBooks = new ArrayList<>();
        issuedBooks.add(new Book("Twilight", "Unknown", 2000));
        books = new Books(availableBooks, issuedBooks);
    }

    @Test
    public void shouldBeAbleToReturnAvailableBookDetails() {
        String actualBookDetails = books.availableBooks();

        assertThat(actualBookDetails, is(equalTo("| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |\n" +
                "| Harry Potter and The Chamber of Secrets | JK Rowling | 2000 |\n")));
    }


    @Test
    public void shouldReturnSuccessMessageOnSuccessfulCheckout() {
        String actualMessage = books.checkoutBook("Harry Potter and The Chamber of Secrets");

        assertThat(actualMessage, is(equalTo("Thank you! Enjoy the book.")));
    }

    @Test
    public void shouldReturnErrorMessageOnUnSuccessfulCheckout() {
        String actualMessage = books.checkoutBook("Twilight");

        assertThat(actualMessage, is(equalTo("That book is not available!")));
    }

    @Test
    public void shouldBeAbleToReturnSuccessMessageOnSuccessfulReturn() {
        String actualMessage = books.returnBook("Twilight");

        assertThat(actualMessage, is(equalTo("Thank you for returning the book.")));
    }

    @Test
    public void shouldBeAbleToReturnErrorMessageOnUnSuccessfulReturn() {
        String actualMessage = books.returnBook("Harry Potter and The Chamber of Secrets");

        assertThat(actualMessage, is(equalTo("That is not a valid book to return.")));
    }

    @Test
    public void equalityShouldSatisfyReflexivity() {
        Books booksOne = new Books(availableBooks, availableBooks);

        assertThat(booksOne, is(equalTo(booksOne)));
    }

    @Test
    public void equalityShouldSatisfySymmetricity() {
        Books booksOne = new Books(availableBooks, availableBooks);
        Books booksTwo = new Books(availableBooks, availableBooks);

        assertThat(booksOne, is(equalTo(booksTwo)));
        assertThat(booksTwo, is(equalTo(booksOne)));
    }

    @Test
    public void equalityShouldSatisfyTransitivity() {
        Books booksOne = new Books(availableBooks, availableBooks);
        Books booksTwo = new Books(availableBooks, availableBooks);
        Books booksThree = new Books(availableBooks, availableBooks);

        assertThat(booksOne, is(equalTo(booksTwo)));
        assertThat(booksTwo, is(equalTo(booksThree)));
        assertThat(booksOne, is(equalTo(booksThree)));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingNull() {
        Books booksOne = new Books(availableBooks, availableBooks);

        assertFalse(booksOne.equals(null));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingOtherObject() {
        Books booksOne = new Books(availableBooks, availableBooks);

        assertFalse(booksOne.equals(new String("Hello, World")));
    }

    @Test
    public void whenTwoObjectsAreEqualThenTheirHashCodeMustBeEqual() {
        Books booksOne = new Books(availableBooks, availableBooks);
        Books booksTwo = new Books(availableBooks, availableBooks);

        assertThat(booksOne, is(equalTo(booksTwo)));
        assertThat(booksOne.hashCode(), is(equalTo(booksTwo.hashCode())));
    }
}
package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    private Library library;
    private List<Book> availableBooks;
    private List<Book> issuedBooks;

    @Before
    public void setUp() throws Exception {
        availableBooks = new ArrayList<>();
        availableBooks.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        availableBooks.add(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000));
        issuedBooks = new ArrayList<>();
        issuedBooks.add(new Book("Twilight", "Unknown", 2000));
        library = new Library(availableBooks, issuedBooks);
    }

    @Test
    public void shouldBeAbleToReturnAvailableBookDetails() {
        String actualBookDetails = library.availableBooks();

        assertThat(actualBookDetails, is(equalTo("| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |\n" +
                "| Harry Potter and The Chamber of Secrets | JK Rowling | 2000 |\n")));
    }


    @Test
    public void shouldReturnSuccessMessageOnSuccessfulCheckout() {
        String actualMessage = library.checkoutBook("Harry Potter and The Chamber of Secrets");

        assertThat(actualMessage, is(equalTo("Thank you! Enjoy the book.")));
    }

    @Test
    public void shouldReturnErrorMessageOnUnSuccessfulCheckout() {
        String actualMessage = library.checkoutBook("Twilight");

        assertThat(actualMessage, is(equalTo("That book is not available!")));
    }

    @Test
    public void shouldBeAbleToReturnSuccessMessageOnSuccessfulReturn() {
        String actualMessage = library.returnBook("Twilight");

        assertThat(actualMessage, is(equalTo("Thank you for returning the book.")));
    }

    @Test
    public void shouldBeAbleToReturnErrorMessageOnUnSuccessfulReturn() {
        String actualMessage = library.returnBook("Harry Potter and The Chamber of Secrets");

        assertThat(actualMessage, is(equalTo("That is not a valid book to return.")));
    }
}
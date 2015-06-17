package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.constants.Constants.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SectionTest {
    private Section section;
    private List<Item> availableItems;
    private List<Item> issuedItems;

    @Before
    public void setUp() {
        availableItems = new ArrayList<>();
        availableItems.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        availableItems.add(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000));
        availableItems.add(new Movie("Inception", "Christopher Nolan", 2010, "10"));
        availableItems.add(new Movie("The Prestige", "Christopher Nolan", 2008, "10"));
        issuedItems = new ArrayList<>();
        issuedItems.add(new Book("Twilight", "Unknown", 2000));
        issuedItems.add(new Movie("Lucy", "Unknown Director", 2014, "10"));
        section = new Section(availableItems, issuedItems);
    }

    @Test
    public void shouldBeAbleToReturnAvailableBookDetails() {
        String actualBookDetails = section.availableItems();

        assertThat(actualBookDetails, is(equalTo("| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |\n" +
                "| Harry Potter and The Chamber of Secrets | JK Rowling | 2000 |\n" +
                "| Inception | Christopher Nolan | 2010 | 10 |\n" +
                "| The Prestige | Christopher Nolan | 2008 | 10 |\n")));
    }


    @Test
    public void shouldReturnSuccessMessageOnSuccessfulCheckoutOfABook() {
        String actualMessage = section.checkoutItem("Harry Potter and The Chamber of Secrets", BOOK_CHECKOUT_SUCCESS_MESSAGE, BOOK_CHECKOUT_FAILURE_MESSAGE);

        assertThat(actualMessage, is(equalTo(BOOK_CHECKOUT_SUCCESS_MESSAGE)));
    }

    @Test
    public void shouldReturnFailureMessageOnUnSuccessfulCheckoutOfABook() {
        String actualMessage = section.checkoutItem("Twilight", BOOK_CHECKOUT_SUCCESS_MESSAGE, BOOK_CHECKOUT_FAILURE_MESSAGE);

        assertThat(actualMessage, is(equalTo(BOOK_CHECKOUT_FAILURE_MESSAGE)));
    }

    @Test
    public void shouldReturnSuccessMessageOnSuccessfulReturnOfABook() {
        String actualMessage = section.returnItem("Twilight", BOOK_RETURN_SUCCESS_MESSAGE, BOOK_RETURN_FAILURE_MESSAGE);

        assertThat(actualMessage, is(equalTo(BOOK_RETURN_SUCCESS_MESSAGE)));
    }

    @Test
    public void shouldReturnFailureMessageOnUnSuccessfulReturnOfABook() {
        String actualMessage = section.returnItem("Harry Potter and The Chamber of Secrets", BOOK_RETURN_SUCCESS_MESSAGE, BOOK_RETURN_FAILURE_MESSAGE);

        assertThat(actualMessage, is(equalTo(BOOK_RETURN_FAILURE_MESSAGE)));
    }

    @Test
    public void shouldReturnSuccessMessageOnSuccessfulCheckoutOfAMovie() {
        String actualMessage = section.checkoutItem("Inception", MOVIE_CHECKOUT_SUCCESS_MESSAGE, MOVIE_CHECKOUT_FAILURE_MESSAGE);

        assertThat(actualMessage, is(equalTo(MOVIE_CHECKOUT_SUCCESS_MESSAGE)));
    }

    @Test
    public void shouldReturnFailureMessageOnUnSuccessfulCheckoutOfAMovie() {
        String actualMessage = section.checkoutItem("Lucy", MOVIE_CHECKOUT_SUCCESS_MESSAGE, MOVIE_CHECKOUT_FAILURE_MESSAGE);

        assertThat(actualMessage, is(equalTo(MOVIE_CHECKOUT_FAILURE_MESSAGE)));
    }

    @Test
    public void shouldReturnSuccessMessageOnSuccessfulReturnOfAMovie() {
        String actualMessage = section.returnItem("Twilight", MOVIE_RETURN_SUCCESS_MESSAGE, MOVIE_RETURN_FAILURE_MESSAGE);

        assertThat(actualMessage, is(equalTo(MOVIE_RETURN_SUCCESS_MESSAGE)));
    }

    @Test
    public void shouldReturnFailureMessageOnUnSuccessfulReturnOfAMovie() {
        String actualMessage = section.returnItem("Inception", MOVIE_RETURN_SUCCESS_MESSAGE, MOVIE_RETURN_FAILURE_MESSAGE);

        assertThat(actualMessage, is(equalTo(MOVIE_RETURN_FAILURE_MESSAGE)));
    }
}
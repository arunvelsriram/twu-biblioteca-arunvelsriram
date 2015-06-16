package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SectionTest {
    private Section section;
    private List<Item> availableItems;
    private List<Item> issuedItems;

    @Before
    public void setUp() {
        availableItems = new ArrayList<>();
        availableItems.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        availableItems.add(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000));
        availableItems.add(new Movie("Inception", "Christopher Nolan", 2010, 10));
        availableItems.add(new Movie("The Prestige", "Christopher Nolan", 2008, 10));
        issuedItems = new ArrayList<>();
        issuedItems.add(new Book("Twilight", "Unknown", 2000));
        issuedItems.add(new Movie("Lucy", "Unknown Director", 2014, 10));
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
    public void shouldReturnTrueOnSuccessfulCheckoutOfABook() {
        boolean actual = section.checkoutItem("Harry Potter and The Chamber of Secrets");

        assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseOnUnSuccessfulCheckoutOfABook() {
        boolean actual = section.checkoutItem("Twilight");

        assertFalse(actual);
    }

    @Test
    public void shouldReturnTrueOnSuccessfulReturnOfABook() {
        boolean actual = section.returnItem("Twilight");

        assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueOnUnSuccessfulReturnOfABook() {
        boolean actual = section.returnItem("Harry Potter and The Chamber of Secrets");

        assertFalse(actual);
    }

    @Test
    public void shouldReturnTrueOnSuccessfulCheckoutOfAMovie() {
        boolean actual = section.checkoutItem("Inception");

        assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseOnUnSuccessfulCheckoutOfAMovie() {
        boolean actual = section.checkoutItem("Lucy");

        assertFalse(actual);
    }

    @Test
    public void shouldReturnTrueOnSuccessfulReturnOfAMovie() {
        boolean actual = section.returnItem("Twilight");

        assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseOnUnSuccessfulReturnOfAMovie() {
        boolean actual = section.returnItem("Inception");

        assertFalse(actual);
    }
}
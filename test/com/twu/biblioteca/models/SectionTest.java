package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void shouldBeAbleToReturnAvailableItemDetails() {
        String actualItemDetails = section.availableItems();

        assertThat(actualItemDetails, is(equalTo("| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |\n" +
                "| Harry Potter and The Chamber of Secrets | JK Rowling | 2000 |\n" +
                "| Inception | Christopher Nolan | 2010 | 10 |\n" +
                "| The Prestige | Christopher Nolan | 2008 | 10 |\n")));
    }

    @Test
    public void shouldBeAbleToReturnIssuedItemDetails() {
        String actualItemDetails = section.issuedItems();

        assertThat(actualItemDetails, is(equalTo("| Twilight | Unknown | 2000 |\n" +
                "| Lucy | Unknown Director | 2014 | 10 |\n")));
    }

    @Test
    public void shouldReturnAListOfAvailableItemsThatMatchesTheGivenName() {
        List<Item> expectedResult = new ArrayList<>();
        expectedResult.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        List<Item> actualResult = section.searchAvailableItems("Harry Potter and The Sorcer's Stone");

        assertThat(actualResult, is(equalTo(expectedResult)));
    }

    @Test
    public void shouldReturnAnEmptyListIfNoAvailableItemMatchesTheGivenName() {
        List<Item> expectedResult = new ArrayList<>();
        List<Item> actualResult = section.searchAvailableItems("Twilight");

        assertThat(actualResult, is(equalTo(expectedResult)));
    }

    @Test
    public void shouldReturnAListOfIssuedItemsThatMatchesTheGivenName() {
        List<Item> expectedResult = new ArrayList<>();
        expectedResult.add(new Book("Twilight", "Unknown", 2000));
        List<Item> actualResult = section.searchIssuedItems("Twilight");

        assertThat(actualResult, is(equalTo(expectedResult)));
    }

    @Test
    public void shouldReturnAnEmptyListIfNoIssuedItemMatchesTheGivenName() {
        List<Item> expectedResult = new ArrayList<>();
        List<Item> actualResult = section.searchIssuedItems("Inception");

        assertThat(actualResult, is(equalTo(expectedResult)));
    }

    @Test
    public void shouldBeAbleToCheckoutABook() {
        section.checkoutItem(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));

        String actualAvailableItemDetails = section.availableItems();
        String actualIssuedItemDetails = section.issuedItems();

        assertThat(actualAvailableItemDetails, is(equalTo("| Harry Potter and The Chamber of Secrets | JK Rowling | 2000 |\n" +
                "| Inception | Christopher Nolan | 2010 | 10 |\n" +
                "| The Prestige | Christopher Nolan | 2008 | 10 |\n")));


        assertThat(actualIssuedItemDetails, is(equalTo("| Twilight | Unknown | 2000 |\n" +
                "| Lucy | Unknown Director | 2014 | 10 |\n" +
                "| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |\n")));
    }

    @Test
    public void shouldBeAbleToReturnABook() {
        section.returnItem(new Movie("Lucy", "Unknown Director", 2014, "10"));

        String actualAvailableItemDetails = section.availableItems();
        String actualIssuedItemDetails = section.issuedItems();

        assertThat(actualAvailableItemDetails, is(equalTo("| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |\n" +
                "| Harry Potter and The Chamber of Secrets | JK Rowling | 2000 |\n" +
                "| Inception | Christopher Nolan | 2010 | 10 |\n" +
                "| The Prestige | Christopher Nolan | 2008 | 10 |\n" +
                "| Lucy | Unknown Director | 2014 | 10 |\n")));

        assertThat(actualIssuedItemDetails, is(equalTo("| Twilight | Unknown | 2000 |\n")));
    }
}

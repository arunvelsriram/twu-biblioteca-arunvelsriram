package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CheckoutHistoryTest {
    private Map<User, List<Item>> history;
    private User user;
    private List<Item> items;
    private Book book;

    @Before
    public void setUp() {
        user = new Member("B1012", "password", "Arun", "arunvelsriram@gmail.com", "919629722335");
        items = new ArrayList<>();
        book = new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999);
        items.add(book);
        history = new LinkedHashMap<>();
        history.put(user, items);
    }

    @Test
    public void equalityShouldSatisfyReflexivity() {
        CheckoutHistory checkoutHistoryOne = new CheckoutHistory(history);

        assertThat(checkoutHistoryOne, is(equalTo(checkoutHistoryOne)));
    }

    @Test
    public void equalityShouldSatisfySymmetricity() {
        CheckoutHistory checkoutHistoryOne = new CheckoutHistory(history);
        CheckoutHistory checkoutHistoryTwo = new CheckoutHistory(history);

        assertThat(checkoutHistoryOne, is(equalTo(checkoutHistoryTwo)));
        assertThat(checkoutHistoryTwo, is(equalTo(checkoutHistoryOne)));
    }

    @Test
    public void equalityShouldSatisfyTransitivity() {
        CheckoutHistory checkoutHistoryOne = new CheckoutHistory(history);
        CheckoutHistory checkoutHistoryTwo = new CheckoutHistory(history);
        CheckoutHistory checkoutHistoryThree = new CheckoutHistory(history);

        assertThat(checkoutHistoryOne, is(equalTo(checkoutHistoryTwo)));
        assertThat(checkoutHistoryTwo, is(equalTo(checkoutHistoryThree)));
        assertThat(checkoutHistoryOne, is(equalTo(checkoutHistoryThree)));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingNull() {
        CheckoutHistory checkoutHistoryOne = new CheckoutHistory(history);

        assertFalse(checkoutHistoryOne.equals(null));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingOtherObject() {
        CheckoutHistory checkoutHistoryOne = new CheckoutHistory(history);

        assertFalse(checkoutHistoryOne.equals(new String("Hello, World")));
    }

    @Test
    public void whenTwoObjectsAreEqualThenTheirHashCodeMustBeEqual() {
        CheckoutHistory checkoutHistoryOne = new CheckoutHistory(history);
        CheckoutHistory checkoutHistoryTwo = new CheckoutHistory(history);

        assertThat(checkoutHistoryOne, is(equalTo(checkoutHistoryTwo)));
        assertThat(checkoutHistoryOne.hashCode(), is(equalTo(checkoutHistoryTwo.hashCode())));
    }


    @Test
    public void shouldBeAbleToStoreUserAndCheckedOutItem() {
        CheckoutHistory expectedCheckoutHistory = new CheckoutHistory(history);

        CheckoutHistory actualCheckoutHistory = new CheckoutHistory(new LinkedHashMap<User, List<Item>>());
        actualCheckoutHistory.store(user, book);

        assertThat(actualCheckoutHistory, is(equalTo(expectedCheckoutHistory)));
    }

    @Test
    public void shouldBeAbleToReturnTheCheckoutHistoryAlongWithUserInformation() {
        CheckoutHistory checkoutHistory = new CheckoutHistory(history);

        String actualHistory = checkoutHistory.toString();

        assertThat(actualHistory, is(equalTo("***User Details***\n" +
                "Library Number: B1012\n" +
                "Name: Arun\n" +
                "Email Address: arunvelsriram@gmail.com\n" +
                "Phone number: 919629722335\n\n" +
                "***Item Details***\n" +
                "| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |\n")));
    }

    @Test
    public void shouldReturnFalseWhenBothUserDetailAndItemDetailIsNotAvailableInTheHistory() {
        CheckoutHistory checkoutHistory = new CheckoutHistory(history);
        User member = new Member("B1015", "pass", "Ajay", "ajayy@gmail.com", "917876567890");
        Item book = new Book("Twilight", "Unknown", 2006);

        boolean actual = checkoutHistory.has(member, book);

        assertFalse(actual);
    }

    @Test
    public void shouldReturnFalseWhenUserIsNotAvailableInTheHistory() {
        CheckoutHistory checkoutHistory = new CheckoutHistory(history);
        User member = new Member("B1015", "pass", "Ajay", "ajayy@gmail.com", "917876567890");

        boolean actual = checkoutHistory.has(member, items.get(0));

        assertFalse(actual);
    }

    @Test
    public void shouldReturnFalseWhenItemIsNotAvailableInTheHistory() {
        CheckoutHistory checkoutHistory = new CheckoutHistory(history);
        Item book = new Book("Twilight", "Unknown", 2006);

        boolean actual = checkoutHistory.has(user, book);

        assertFalse(actual);
    }

    @Test
    public void shouldReturnTrueWhenBothUserDetailAndItemDetailIsAvailableInTheHistory() {
        CheckoutHistory checkoutHistory = new CheckoutHistory(history);

        boolean actual = checkoutHistory.has(user, items.get(0));

        assertTrue(actual);
    }

    @Test
    public void shouldBeAbleToRemoveAnItemForAParticularUser() {
        CheckoutHistory expectedCheckoutHistory = new CheckoutHistory(history);
        items.add(new Movie("The Prestige", "Christopher Nolan", 2006, "10"));
        history.put(user, items);
        CheckoutHistory actualCheckoutHistory = new CheckoutHistory(history);

        actualCheckoutHistory.remove(user, book);

        assertThat(actualCheckoutHistory, is(equalTo(expectedCheckoutHistory)));
    }

    @Test
    public void shouldBeAbleToRemoveAnEntryFromTheHistoryIfTheItemListReducesToZero() {
        Map<User, List<Item>> expectedHistory = new LinkedHashMap<>();
        CheckoutHistory expectedCheckoutHistory = new CheckoutHistory(expectedHistory);
        CheckoutHistory actualCheckoutHistory = new CheckoutHistory(history);

        actualCheckoutHistory.remove(user, book);

        assertThat(actualCheckoutHistory, is(equalTo(expectedCheckoutHistory)));
    }
}
package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.views.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.constants.Constants.MOVIE_CHECKOUT_SUCCESS_MESSAGE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
    @Mock
    private View viewStub;
    @Mock
    private Section sectionStub;
    @Mock
    private Item itemStub;

    private ItemController itemController;
    private Section section;

    @Before
    public void setUp() {
        itemController = new ItemController(viewStub);

        List<Item> availableItem = new ArrayList<>();
        availableItem.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        availableItem.add(new Movie("Inception", "Christopher Nolan", 2010, "10"));

        List<Item> issuedItems = new ArrayList<>();
        issuedItems.add(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000));
        issuedItems.add(new Movie("The Prestige", "Christopher Nolan", 2008, "10"));

        section = new Section(availableItem, issuedItems);
    }

    @Test
    public void shouldBeAbleToDisplayTheAvailableItemsThroughTheView() {
        when(sectionStub.availableItems())
                .thenReturn("List of Items");
        itemController.listAvailableItems(sectionStub);

        verify(viewStub).write(sectionStub.availableItems());
    }

    @Test
    public void shouldBeAbleToGetItemNameFromTheUserThroughTheViewForSearchingTheAvailableItems() {
        itemController.searchAvailableItems(sectionStub);

        verify(viewStub).read();
    }

    @Test
    public void shouldBeAbleToReturnAvailableItemsThatMatchesTheGivenName() {
        when(viewStub.read())
                .thenReturn("Inception");
        List<Item> expectedResult = new ArrayList<>();
        expectedResult.add(new Movie("Inception", "Christopher Nolan", 2010, "10"));

        List<Item> actualResult = itemController.searchAvailableItems(section);

        assertThat(actualResult, is(equalTo(expectedResult)));
    }

    @Test
    public void shouldBeAbleToReturnAnEmptyListWhenNoAvailableItemMatchesTheGivenName() {
        when(viewStub.read())
                .thenReturn("The Prestige");
        List<Item> expectedResult = new ArrayList<>();

        List<Item> actualResult = itemController.searchAvailableItems(section);

        assertThat(actualResult, is(equalTo(expectedResult)));
    }

    @Test
    public void shouldBeAbleToGetItemNameFromTheUserThroughTheViewForSearchingTheIssuedItems() {
        itemController.searchIssuedItems(sectionStub);

        verify(viewStub).read();
    }

    @Test
    public void shouldBeAbleToReturnIssuedItemsThatMatchesTheGivenName() {
        when(viewStub.read())
                .thenReturn("The Prestige");
        List<Item> expectedResult = new ArrayList<>();
        expectedResult.add(new Movie("The Prestige", "Christopher Nolan", 2008, "10"));

        List<Item> actualResult = itemController.searchIssuedItems(section);

        assertThat(actualResult, is(equalTo(expectedResult)));
    }

    @Test
    public void shouldBeAbleToReturnAnEmptyListWhenNoIssuedItemMatchesTheGivenName() {
        when(viewStub.read())
                .thenReturn("Inception");
        List<Item> expectedResult = new ArrayList<>();

        List<Item> actualResult = itemController.searchIssuedItems(section);

        assertThat(actualResult, is(equalTo(expectedResult)));
    }

    @Test
    public void shouldBeAbleToCheckoutAnItem() {
        itemController.checkoutAnItem(sectionStub, itemStub);

        verify(sectionStub).checkoutItem(itemStub);
    }

    @Test
    public void shouldBeAbleToReturnAnItem() {
        itemController.returnAnItem(sectionStub, itemStub);

        verify(sectionStub).returnItem(itemStub);
    }

    @Test
    public void shouldBeAbleToWriteTheResultOfACheckoutOrReturnToTheView() {
        itemController.result(MOVIE_CHECKOUT_SUCCESS_MESSAGE);

        verify(viewStub).write(MOVIE_CHECKOUT_SUCCESS_MESSAGE);
    }
}
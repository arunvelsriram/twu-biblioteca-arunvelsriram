package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.Section;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.constants.Constants.MOVIE_CHECKOUT_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.MOVIE_CHECKOUT_SUCCESS_MESSAGE;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutMovieActionTest {
    @Mock
    private ItemController itemControllerStub;
    @Mock
    private Section sectionStub;

    private CheckoutMovieAction checkoutMovieAction;

    @Before
    public void setUp() throws Exception {
        checkoutMovieAction = new CheckoutMovieAction(itemControllerStub, sectionStub);
    }

    @Test
    public void shouldBeABleToInteractWithTheItemControllerToCheckoutAMovie() {
        checkoutMovieAction.performAction();

        verify(itemControllerStub).searchAvailableItems(sectionStub);
    }

    @Test
    public void shouldBeAbleToCheckoutFirstItemInTheListSinceTheListWillBeAlwaysOfLengthOneDueToUniqueTitle() {
        List<Item> availableItems = new ArrayList<>();
        availableItems.add(new Movie("Inception", "Christopher Nolan", 2010, "10"));
        when(itemControllerStub.searchAvailableItems(sectionStub))
                .thenReturn(availableItems);

        checkoutMovieAction.performAction();

        verify(itemControllerStub, times(1)).checkoutAnItem(sectionStub, availableItems.get(0));
    }

    @Test
    public void shouldBeAbleToPassSuccessfulCheckoutMessage() {
        List<Item> availableItems = new ArrayList<>();
        availableItems.add(new Movie("Inception", "Christopher Nolan", 2010, "10"));
        when(itemControllerStub.searchAvailableItems(sectionStub))
                .thenReturn(availableItems);

        checkoutMovieAction.performAction();

        verify(itemControllerStub, times(1)).result(MOVIE_CHECKOUT_SUCCESS_MESSAGE);
    }

    @Test
    public void shouldBeAbleToPassUnSuccessfulCheckoutMessage() {
        List<Item> availableItems = new ArrayList<>();
        when(itemControllerStub.searchAvailableItems(sectionStub))
                .thenReturn(availableItems);

        checkoutMovieAction.performAction();

        verify(itemControllerStub, times(1)).result(MOVIE_CHECKOUT_FAILURE_MESSAGE);
    }
}
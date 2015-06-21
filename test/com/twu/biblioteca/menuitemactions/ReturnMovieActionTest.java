package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.controllers.LoginController;
import com.twu.biblioteca.models.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.constants.Constants.MOVIE_RETURN_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.MOVIE_RETURN_SUCCESS_MESSAGE;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReturnMovieActionTest {
    @Mock
    private ItemController itemControllerStub;
    @Mock
    private Section sectionStub;
    @Mock
    private LoginController loginControllerStub;
    @Mock
    private CheckoutHistory checkoutHistoryStub;
    @Mock
    private User userStub;

    private ReturnMovieAction returnMovieAction;

    @Before
    public void setUp() throws Exception {
        returnMovieAction = new ReturnMovieAction(itemControllerStub, sectionStub, loginControllerStub, checkoutHistoryStub);
        returnMovieAction.update(userStub);
    }

    @Test
    public void shouldBeAbleToInteractWithItemControllerToSearchForIssuedMovies() {
        returnMovieAction.performAction();

        verify(itemControllerStub).searchIssuedItems(sectionStub);
    }

    @Test
    public void shouldPrintFailureMessageIfTheIssuedItemsListIsEmpty() {
        List<Item> issuedItems = new ArrayList<>();
        when(itemControllerStub.searchIssuedItems(sectionStub))
                .thenReturn(issuedItems);

        returnMovieAction.performAction();

        verify(itemControllerStub).result(MOVIE_RETURN_FAILURE_MESSAGE);
    }

    @Test
    public void shouldBeAbleToReturnTheItemIfTheIssuedItemsListIsNotEmpty() {
        List<Item> issuedItems = new ArrayList<>();
        issuedItems.add(new Movie("Inception", "Christopher Nolan", 2010, "10"));
        when(itemControllerStub.searchIssuedItems(sectionStub))
                .thenReturn(issuedItems);
        when(checkoutHistoryStub.has(userStub, issuedItems.get(0)))
                .thenReturn(true);

        returnMovieAction.performAction();

        verify(itemControllerStub).returnAnItem(sectionStub, issuedItems.get(0));
    }

    @Test
    public void shouldPrintSuccessMessageIfTheIssuedItemsListIsNotEmpty() {
        List<Item> issuedItems = new ArrayList<>();
        issuedItems.add(new Movie("Inception", "Christopher Nolan", 2010, "10"));
        when(itemControllerStub.searchIssuedItems(sectionStub))
                .thenReturn(issuedItems);
        when(checkoutHistoryStub.has(userStub, issuedItems.get(0)))
                .thenReturn(true);

        returnMovieAction.performAction();

        verify(itemControllerStub).result(MOVIE_RETURN_SUCCESS_MESSAGE);
    }

    @Test
    public void shouldBeAbleToRemoveFromHistoryIfTheIssuedItemsListIsNotEmpty() {
        List<Item> issuedItems = new ArrayList<>();
        issuedItems.add(new Movie("Inception", "Christopher Nolan", 2010, "10"));
        when(itemControllerStub.searchIssuedItems(sectionStub))
                .thenReturn(issuedItems);
        when(checkoutHistoryStub.has(userStub, issuedItems.get(0)))
                .thenReturn(true);

        returnMovieAction.performAction();

        verify(checkoutHistoryStub).remove(userStub, issuedItems.get(0));
    }

    @Test
    public void shouldBeAbleToPrintFailureMessageIfTheCheckoutHistoryHasNoEntryForTheGivenUserAndItem() {
        List<Item> issuedItems = new ArrayList<>();
        issuedItems.add(new Movie("Inception", "Christopher Nolan", 2010, "10"));
        when(itemControllerStub.searchIssuedItems(sectionStub))
                .thenReturn(issuedItems);
        when(checkoutHistoryStub.has(userStub, issuedItems.get(0)))
                .thenReturn(false);

        returnMovieAction.performAction();

        verify(itemControllerStub).result(MOVIE_RETURN_FAILURE_MESSAGE);
    }
}
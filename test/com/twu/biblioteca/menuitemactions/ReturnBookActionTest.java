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

import static com.twu.biblioteca.constants.Constants.BOOK_RETURN_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.BOOK_RETURN_SUCCESS_MESSAGE;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookActionTest {
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
    @Mock
    private Item itemStub;

    private ReturnBookAction returnBookAction;

    @Before
    public void setUp() {
        returnBookAction = new ReturnBookAction(itemControllerStub, sectionStub, loginControllerStub, checkoutHistoryStub);
        returnBookAction.update(userStub);
    }

    @Test
    public void shouldBeAbleToInteractWithItemControllerToSearchForIssuedBooks() {
        returnBookAction.performAction();

        verify(itemControllerStub).searchIssuedItems(sectionStub);
    }

    @Test
    public void shouldPrintFailureMessageIfTheIssuedItemsListIsEmpty() {
        List<Item> issuedItems = new ArrayList<>();
        when(itemControllerStub.searchIssuedItems(sectionStub))
                .thenReturn(issuedItems);

        returnBookAction.performAction();

        verify(itemControllerStub).result(BOOK_RETURN_FAILURE_MESSAGE);
    }

    @Test
    public void shouldBeAbleToReturnTheItemIfTheIssuedItemsListIsNotEmpty() {
        List<Item> issuedItems = new ArrayList<>();
        issuedItems.add(new Movie("Inception", "Christopher Nolan", 2010, "10"));
        when(itemControllerStub.searchIssuedItems(sectionStub))
                .thenReturn(issuedItems);
        when(checkoutHistoryStub.has(userStub, issuedItems.get(0)))
                .thenReturn(true);

        returnBookAction.performAction();

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

        returnBookAction.performAction();

        verify(itemControllerStub).result(BOOK_RETURN_SUCCESS_MESSAGE);
    }

    @Test
    public void shouldBeAbleToRemoveFromHistoryIfTheIssuedItemsListIsNotEmpty() {
        List<Item> issuedItems = new ArrayList<>();
        issuedItems.add(new Movie("Inception", "Christopher Nolan", 2010, "10"));
        when(itemControllerStub.searchIssuedItems(sectionStub))
                .thenReturn(issuedItems);
        when(checkoutHistoryStub.has(userStub, issuedItems.get(0)))
                .thenReturn(true);

        returnBookAction.performAction();

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

        returnBookAction.performAction();

        verify(itemControllerStub).result(BOOK_RETURN_FAILURE_MESSAGE);
    }
}
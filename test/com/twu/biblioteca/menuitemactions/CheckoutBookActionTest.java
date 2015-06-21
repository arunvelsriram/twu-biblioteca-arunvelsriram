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

import static com.twu.biblioteca.constants.Constants.BOOK_CHECKOUT_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.BOOK_CHECKOUT_SUCCESS_MESSAGE;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutBookActionTest {
    @Mock
    private ItemController itemControllerStub;
    @Mock
    private Section sectionStub;
    @Mock
    private LoginController loginControllerStub;
    @Mock
    private CheckoutHistory checkoutHistoryStub;

    private CheckoutBookAction checkoutBookAction;
    private User user;


    @Before
    public void setUp() {
        checkoutBookAction = new CheckoutBookAction(itemControllerStub, sectionStub, loginControllerStub, checkoutHistoryStub);
        user = new Member("B1013", "pword", "Priya", "priya33@gmail.com", "918989876767");
        checkoutBookAction.update(user);
    }

    @Test
    public void shouldBeAbleToInteractWithItemControllerToSearchForAvailableBooks() {
        checkoutBookAction.performAction();

        verify(itemControllerStub).searchAvailableItems(sectionStub);
    }

    @Test
    public void shouldBeAbleToCheckoutFirstItemInTheListSinceTheListWillBeAlwaysOfLengthOneDueToUniqueTitle() {
        List<Item> availableItems = new ArrayList<>();
        availableItems.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        when(itemControllerStub.searchAvailableItems(sectionStub))
                .thenReturn(availableItems);

        checkoutBookAction.performAction();

        verify(itemControllerStub, times(1)).checkoutAnItem(sectionStub, availableItems.get(0));
    }

    @Test
    public void shouldBeAbleToPassSuccessfulCheckoutMessage() {
        List<Item> availableItems = new ArrayList<>();
        availableItems.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        when(itemControllerStub.searchAvailableItems(sectionStub))
                .thenReturn(availableItems);

        checkoutBookAction.performAction();

        verify(itemControllerStub, times(1)).result(BOOK_CHECKOUT_SUCCESS_MESSAGE);
    }

    @Test
    public void shouldBeAbleToSendTheCheckoutDetailsToCheckoutHistory() {
        List<Item> availableItems = new ArrayList<>();
        availableItems.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        when(itemControllerStub.searchAvailableItems(sectionStub))
                .thenReturn(availableItems);

        checkoutBookAction.performAction();

        verify(checkoutHistoryStub).store(user, availableItems.get(0));
    }

    @Test
    public void shouldBeAbleToPassUnSuccessfulCheckoutMessage() {
        List<Item> availableItems = new ArrayList<>();
        when(itemControllerStub.searchAvailableItems(sectionStub))
                .thenReturn(availableItems);

        checkoutBookAction.performAction();

        verify(itemControllerStub, times(1)).result(BOOK_CHECKOUT_FAILURE_MESSAGE);
    }
}
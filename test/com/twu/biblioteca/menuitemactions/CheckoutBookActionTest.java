package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Section;
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
    private CheckoutBookAction checkoutBookAction;


    @Before
    public void setUp() {
        checkoutBookAction = new CheckoutBookAction(itemControllerStub, sectionStub);
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
    public void shouldBeAbleToPassUnSuccessfulCheckoutMessage() {
        List<Item> availableItems = new ArrayList<>();
        when(itemControllerStub.searchAvailableItems(sectionStub))
                .thenReturn(availableItems);

        checkoutBookAction.performAction();

        verify(itemControllerStub, times(1)).result(BOOK_CHECKOUT_FAILURE_MESSAGE);
    }
}
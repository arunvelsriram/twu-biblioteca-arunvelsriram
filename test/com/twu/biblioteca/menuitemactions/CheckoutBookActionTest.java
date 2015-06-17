package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.constants.Constants.BOOK_CHECKOUT_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.BOOK_CHECKOUT_SUCCESS_MESSAGE;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutBookActionTest {
    @Mock
    private ItemController itemControllerStub;
    @Mock
    private Section sectionStub;


    @Test
    public void shouldBeAbleToInteractWithItemControllerToCheckOutABook() {
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(itemControllerStub, sectionStub);
        checkoutBookAction.performAction();

        verify(itemControllerStub).checkoutAnItem(sectionStub, BOOK_CHECKOUT_SUCCESS_MESSAGE, BOOK_CHECKOUT_FAILURE_MESSAGE);
    }
}
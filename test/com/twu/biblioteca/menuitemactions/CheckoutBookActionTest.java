package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.BooksController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutBookActionTest {
    @Mock
    private BooksController booksControllerStub;

    private CheckoutBookAction checkoutBookAction;

    @Before
    public void setUp() {
        checkoutBookAction = new CheckoutBookAction(booksControllerStub);
    }

    @Test
    public void shouldBeAbleToPerformCheckOutBookAction() {
        checkoutBookAction.performAction();

        Mockito.verify(booksControllerStub).checkoutABook();
    }
}
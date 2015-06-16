package com.twu.biblioteca.menuitemaction;

import com.twu.biblioteca.controllers.BooksController;
import com.twu.biblioteca.menuitemactions.CheckoutBookAction;
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
    public void setUp() throws Exception {
        checkoutBookAction = new CheckoutBookAction(booksControllerStub);
    }

    @Test
    public void shouldBeAbleToPerformCheckOutBookAction() throws Exception {
        checkoutBookAction.performAction();

        Mockito.verify(booksControllerStub).checkoutABook();
    }
}
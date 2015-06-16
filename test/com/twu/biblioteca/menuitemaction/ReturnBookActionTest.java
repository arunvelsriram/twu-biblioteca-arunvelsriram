package com.twu.biblioteca.menuitemaction;

import com.twu.biblioteca.controllers.BooksController;
import com.twu.biblioteca.menuitemactions.ReturnBookAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookActionTest {
    @Mock
    private BooksController booksControllerStub;

    @Test
    public void shouldBeAbleToInvokeReturnBookOnBooksController() throws Exception {
        ReturnBookAction returnBookAction = new ReturnBookAction(booksControllerStub);
        returnBookAction.performAction();

        Mockito.verify(booksControllerStub).returnABook();
    }
}
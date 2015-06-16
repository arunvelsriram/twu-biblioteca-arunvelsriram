package com.twu.biblioteca.menuitemaction;

import com.twu.biblioteca.controllers.BooksController;
import com.twu.biblioteca.menuitemactions.ListBooksAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListLibraryActionTest {
    @Mock
    private BooksController booksControllerStub;

    @Test
    public void shouldDisplayBookDetailsThroughView() throws Exception {
        ListBooksAction listBooksAction = new ListBooksAction(booksControllerStub);
        listBooksAction.performAction();

        verify(booksControllerStub).listAvailableBooks();
    }
}
package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.BooksController;
import com.twu.biblioteca.menuitemactions.ListBooksAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListSectionActionTest {
    @Mock
    private BooksController booksControllerStub;

    @Test
    public void shouldDisplayBookDetailsThroughView() {
        ListBooksAction listBooksAction = new ListBooksAction(booksControllerStub);
        listBooksAction.performAction();

        verify(booksControllerStub).listAvailableBooks();
    }
}
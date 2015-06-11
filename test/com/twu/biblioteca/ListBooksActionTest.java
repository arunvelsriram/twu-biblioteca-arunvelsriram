package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListBooksActionTest {
    @Mock
    private BooksController mockBooksController;

    @Test
    public void shouldDisplayBookDetailsThroughView() throws Exception {
        ListBooksAction listBooksAction = new ListBooksAction(mockBooksController);
        listBooksAction.performAction();

        verify(mockBooksController).listBooks();
    }
}
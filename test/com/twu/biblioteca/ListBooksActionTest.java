package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ListBooksActionTest {
    @Mock
    private View mockView;
    @Mock
    private Books mockBooks;

    @Test
    public void shouldInvokeAMethodOnBooksViewToDisplayTheListOfBooks() throws Exception {
        MenuItemAction menuItemAction = new ListBooksAction(mockView, mockBooks);
        menuItemAction.performAction();

        Mockito.verify(mockView).write(mockBooks.toString());
    }
}
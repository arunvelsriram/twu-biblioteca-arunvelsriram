package com.twu.biblioteca;

import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BooksControllerTest {
    @Mock
    private Books mockBooks;
    @Mock
    private View mockView;

    private BooksController booksController;

    @Before
    public void setUp() throws Exception {
        booksController = new BooksController(mockBooks, mockView);
    }

    @Test
    public void shouldSendBookDetailsToTheViewForDisplaying() throws Exception {
        when(mockBooks.toString())
                .thenReturn("Book details");
        booksController.listBooks();

        Mockito.verify(mockView).write(mockBooks.toString());
    }
}
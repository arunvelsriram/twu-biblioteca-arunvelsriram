package com.twu.biblioteca;

import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.views.View;
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
    private Books booksStub;
    @Mock
    private View viewStub;

    private BooksController booksController;

    @Before
    public void setUp() throws Exception {
        booksController = new BooksController(booksStub, viewStub);
    }

    @Test
    public void shouldSendBookDetailsToTheViewForDisplaying() throws Exception {
        when(booksStub.toString())
                .thenReturn("Book details");
        booksController.listBooks();

        Mockito.verify(viewStub).write(booksStub.toString());
    }
}
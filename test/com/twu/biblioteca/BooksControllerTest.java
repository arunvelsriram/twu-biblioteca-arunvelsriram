package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.views.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BooksControllerTest {
    @Mock
    private Books booksStub;
    @Mock
    private Book bookStub;
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

        verify(viewStub).write(booksStub.toString());
    }

    @Test
    public void shouldBeAbleToGetABookUsingBookName() throws Exception {
        when(viewStub.read())
                .thenReturn("Harry Potter and The Sorcer's Stone");
        when(booksStub.book("Harry Potter and The Sorcer's Stone"))
                .thenReturn(bookStub);
        booksController.checkoutBook();

        verify(booksStub).remove(bookStub);
        verify(viewStub).write("Thank you! Enjoy the book!");
    }

    @Test
    public void shouldBeAbleToPassErrorMessageToView() throws Exception {
        when(viewStub.read())
                .thenReturn("Twilight");
        when(booksStub.book("Twilight"))
                .thenReturn(null);
        booksController.checkoutBook();

        verify(viewStub).write("That book is not available!");
    }
}
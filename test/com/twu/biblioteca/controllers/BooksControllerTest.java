package com.twu.biblioteca.controllers;

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
    public void shouldSendBookDetailsToTheViewForDisplayingIt() throws Exception {
        when(booksStub.toString())
                .thenReturn("Book details");
        booksController.listBooks();

        verify(viewStub).write(booksStub.toString());
    }

    @Test
    public void shouldBeAbleToSearchABookUsingTitle() throws Exception {
        when(viewStub.read())
                .thenReturn("Harry Potter and The Sorcer's Stone");
        booksController.checkoutBook();

        verify(booksStub).search("Harry Potter and The Sorcer's Stone");
    }

    @Test
    public void shouldBeAbleToCheckoutABook() throws Exception {
        when(viewStub.read())
                .thenReturn("Harry Potter and The Sorcer's Stone");
        when(booksStub.search("Harry Potter and The Sorcer's Stone"))
                .thenReturn(bookStub);
        booksController.checkoutBook();

        verify(booksStub).checkOut(bookStub);
    }

    @Test
    public void shouldBeAbleToDisplaySuccessMessageOnSuccessfulCheckout() throws Exception {
        when(viewStub.read())
                .thenReturn("Harry Potter and The Sorcer's Stone");
        when(booksStub.search("Harry Potter and The Sorcer's Stone"))
                .thenReturn(bookStub);
        booksController.checkoutBook();

        verify(viewStub).write("Thank you! Enjoy the book!");
    }

    @Test
    public void shouldBeAbleToPassErrorMessageToView() throws Exception {
        when(viewStub.read())
                .thenReturn("Twilight");
        when(booksStub.search("Twilight"))
                .thenReturn(null);
        booksController.checkoutBook();

        verify(viewStub).write("That book is not available!");
    }
}
package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.views.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LibraryControllerTest {
    @Mock
    private Library libraryStub;
    @Mock
    private Book bookStub;
    @Mock
    private View viewStub;

    private BooksController booksController;

    @Before
    public void setUp() throws Exception {
        booksController = new BooksController(libraryStub, viewStub);
    }

    @Test
    public void shouldSendBookDetailsToTheViewForDisplayingIt() throws Exception {
        when(libraryStub.toString())
                .thenReturn("Book details");
        booksController.listAvailableBooks();

        verify(viewStub).write(libraryStub.availableBooks());
    }

    @Test
    public void shouldGetTitleFromTheUserThroughTheView() throws Exception {
        booksController.checkoutABook();

        verify(viewStub).read();
    }

    @Test
    public void shouldBeAbleToCheckoutABookThroughTheLibraryUsingTheTitle() {
        when(viewStub.read())
                .thenReturn("Harry Potter and The Chamber of Secrets");
        when(libraryStub.checkoutBook("Harry Potter and The Chamber of Secrets"))
                .thenReturn("Thank you! Enjoy the book.");
        booksController.checkoutABook();

        verify(viewStub).write("Thank you! Enjoy the book.");
    }

    @Test
    public void shouldBeAbleToReturnABookThroughTheLibraryUsingTheTitle() {
        when(viewStub.read())
                .thenReturn("Twilight");
        when(libraryStub.returnBook("Twilight"))
                .thenReturn("Thank you for returning the book.");
        booksController.returnABook();

        verify(viewStub).write("Thank you for returning the book.");
    }
}
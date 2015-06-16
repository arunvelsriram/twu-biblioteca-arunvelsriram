package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Section;
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
    private Section sectionStub;
    @Mock
    private Book bookStub;
    @Mock
    private View viewStub;

    private BooksController booksController;

    @Before
    public void setUp() {
        booksController = new BooksController(sectionStub, viewStub);
    }

    @Test
    public void shouldSendBookDetailsToTheViewForDisplayingIt() {
        when(sectionStub.toString())
                .thenReturn("Book details");
        booksController.listAvailableBooks();

        verify(viewStub).write(sectionStub.availableItems());
    }

    @Test
    public void shouldGetBookTitleFromTheUserThroughTheView() {
        booksController.checkoutABook();

        verify(viewStub).read();
    }


    @Test
    public void shouldBeAbleToInvokeCheckout() {
        when(viewStub.read())
                .thenReturn("Harry Potter and The Chamber of Secrets");
        booksController.checkoutABook();

        verify(sectionStub).checkoutItem("Harry Potter and The Chamber of Secrets");
    }

    @Test
    public void shouldBeAbleToDisplaySuccessMessageThroughTheViewOnSuccessfulCheckoutOfABook() {
        when(viewStub.read())
                .thenReturn("Harry Potter and The Chamber of Secrets");
        when(sectionStub.checkoutItem("Harry Potter and The Chamber of Secrets"))
                .thenReturn(true);
        booksController.checkoutABook();

        verify(viewStub).write("Thank you! Enjoy the book.");
    }

    @Test
    public void shouldBeAbleToDisplayFailureMessageThroughTheViewOnUnSuccessfulCheckoutOfABook() {
        when(viewStub.read())
                .thenReturn("Harry Potter and The Chamber of Secrets");
        when(sectionStub.checkoutItem("Harry Potter and The Chamber of Secrets"))
                .thenReturn(false);
        booksController.checkoutABook();

        verify(viewStub).write("That book is not available.");
    }

    @Test
    public void shouldBeAbleToInvokeReturn() {
        when(viewStub.read())
                .thenReturn("Harry Potter and The Chamber of Secrets");
        booksController.returnABook();

        verify(sectionStub).returnItem("Harry Potter and The Chamber of Secrets");
    }


    @Test
    public void shouldBeAbleToDisplaySuccessMessageThroughTheViewOnSuccessfulReturnOfABook() {
        when(viewStub.read())
                .thenReturn("Twilight");
        when(sectionStub.returnItem("Twilight"))
                .thenReturn(true);
        booksController.returnABook();

        verify(viewStub).write("Thank you for returning the book.");
    }

    @Test
    public void shouldBeAbleToDisplayFailureMessageThroughTheViewOnUnSuccessfulReturn() {
        when(viewStub.read())
                .thenReturn("Twilight");
        when(sectionStub.returnItem("Twilight"))
                .thenReturn(false);
        booksController.returnABook();

        verify(viewStub).write("That is not a valid book to return.");
    }
}
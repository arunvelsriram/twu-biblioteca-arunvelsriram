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
public class MoviesControllerTest {
    @Mock
    private Section sectionStub;
    @Mock
    private Book bookStub;
    @Mock
    private View viewStub;

    private MoviesController moviesController;

    @Before
    public void setUp() {
        moviesController = new MoviesController(sectionStub, viewStub);
    }

    @Test
    public void shouldSendMovieDetailsToTheViewForDisplayingIt() throws Exception {
        when(sectionStub.toString())
                .thenReturn("Movie details");
        moviesController.listAvailableMovies();

        verify(viewStub).write(sectionStub.availableItems());
    }

    @Test
    public void shouldGetMovieNameFromTheUserThroughTheView() throws Exception {
        moviesController.checkoutAMovie();

        verify(viewStub).read();
    }


    @Test
    public void shouldBeAbleToInvokeCheckout() {
        when(viewStub.read())
                .thenReturn("Inception");
        moviesController.checkoutAMovie();

        verify(sectionStub).checkoutItem("Inception");
    }

    @Test
    public void shouldBeAbleToDisplaySuccessMessageThroughTheViewOnSuccessfulCheckout() {
        when(viewStub.read())
                .thenReturn("Inception");
        when(sectionStub.checkoutItem("Inception"))
                .thenReturn(true);
        moviesController.checkoutAMovie();

        verify(viewStub).write("Thank you! Enjoy the movie.");
    }

    @Test
    public void shouldBeAbleToDisplayFailureMessageThroughTheViewOnUnSuccessfulCheckout() {
        when(viewStub.read())
                .thenReturn("Twilight");
        when(sectionStub.checkoutItem(""))
                .thenReturn(false);
        moviesController.checkoutAMovie();

        verify(viewStub).write("That movie is not available.");
    }
}
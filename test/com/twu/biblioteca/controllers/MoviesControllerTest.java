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
}
package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.MoviesController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListMoviesActionTest {
    @Mock
    private MoviesController moviesControllerStub;

    @Test
    public void shouldBeABleToInteractWithTheMovieControllerToDisplayMovieDetails() {
        ListMoviesAction listMoviesAction = new ListMoviesAction(moviesControllerStub);
        listMoviesAction.performAction();

        verify(moviesControllerStub).listAvailableMovies();
    }
}
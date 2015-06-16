package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.MoviesController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReturnMovieActionTest {
    @Mock
    private MoviesController moviesControllerStub;

    @Test
    public void shouldBeAbleToReturnAMovieByInteractingWithTheController() {
        ReturnMovieAction returnMovieAction = new ReturnMovieAction(moviesControllerStub);
        returnMovieAction.performAction();

        verify(moviesControllerStub).returnAMovie();
    }
}
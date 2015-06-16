package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.MoviesController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutMovieActionTest {
    @Mock
    private MoviesController moviesControllerStub;

    @Test
    public void shouldBeABleToInteractWithTheMovieControllerToDisplayMovieDetails() {
        CheckoutMovieAction checkoutMovieAction = new CheckoutMovieAction(moviesControllerStub);
        checkoutMovieAction.performAction();

        verify(moviesControllerStub).checkoutAMovie();
    }
}
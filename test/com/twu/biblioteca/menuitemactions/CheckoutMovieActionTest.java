package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.constants.Constants.MOVIE_CHECKOUT_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.MOVIE_CHECKOUT_SUCCESS_MESSAGE;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutMovieActionTest {
    @Mock
    private ItemController itemControllerStub;
    @Mock
    private Section sectionStub;

    @Test
    public void shouldBeABleToInteractWithTheItemControllerToCheckoutAMovie() {
        CheckoutMovieAction checkoutMovieAction = new CheckoutMovieAction(itemControllerStub, sectionStub);
        checkoutMovieAction.performAction();

        verify(itemControllerStub).checkoutAnItem(sectionStub, MOVIE_CHECKOUT_SUCCESS_MESSAGE, MOVIE_CHECKOUT_FAILURE_MESSAGE);
    }
}
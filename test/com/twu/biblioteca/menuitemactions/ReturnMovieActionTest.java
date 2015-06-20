package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.controllers.LoginController;
import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.Section;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.constants.Constants.MOVIE_RETURN_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.MOVIE_RETURN_SUCCESS_MESSAGE;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReturnMovieActionTest {
    @Mock
    private ItemController itemControllerStub;
    @Mock
    private Section sectionStub;
    @Mock
    private LoginController loginControllerStub;

    private ReturnMovieAction returnMovieAction;

    @Before
    public void setUp() throws Exception {
        returnMovieAction = new ReturnMovieAction(itemControllerStub, sectionStub, loginControllerStub);
    }

    @Test
    public void shouldBeAbleToReturnAMovieByInteractingWithTheController() {
        returnMovieAction.performAction();

        verify(itemControllerStub).searchIssuedItems(sectionStub);
    }

    @Test
    public void shouldBeAbleToReturnFirstItemInTheListSinceTheListWillBeAlwaysOfLengthOneDueToUniqueTitle() {
        List<Item> issuedItems = new ArrayList<>();
        issuedItems.add(new Movie("Inception", "Christopher Nolan", 2010, "10"));
        when(itemControllerStub.searchIssuedItems(sectionStub))
                .thenReturn(issuedItems);

        returnMovieAction.performAction();

        verify(itemControllerStub, times(1)).returnAnItem(sectionStub, issuedItems.get(0));
    }

    @Test
    public void shouldBeAbleToPassSuccessfulReturnMessage() {
        List<Item> issuedItems = new ArrayList<>();
        issuedItems.add(new Movie("Inception", "Christopher Nolan", 2010, "10"));
        when(itemControllerStub.searchIssuedItems(sectionStub))
                .thenReturn(issuedItems);

        returnMovieAction.performAction();

        verify(itemControllerStub, times(1)).result(MOVIE_RETURN_SUCCESS_MESSAGE);
    }

    @Test
    public void shouldBeAbleToPassUnSuccessfulCheckoutMessage() {
        List<Item> availableItems = new ArrayList<>();
        when(itemControllerStub.searchIssuedItems(sectionStub))
                .thenReturn(availableItems);

        returnMovieAction.performAction();

        verify(itemControllerStub, times(1)).result(MOVIE_RETURN_FAILURE_MESSAGE);
    }
}
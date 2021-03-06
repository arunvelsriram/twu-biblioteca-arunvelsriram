package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListMoviesActionTest {
    @Mock
    private ItemController itemControllerStub;
    @Mock
    private Section sectionStub;

    @Test
    public void shouldBeABleToInteractWithTheItemControllerToDisplayMovieDetails() {
        ListMoviesAction listMoviesAction = new ListMoviesAction(itemControllerStub, sectionStub);
        listMoviesAction.performAction();

        verify(itemControllerStub).listAvailableItems(sectionStub);
    }
}
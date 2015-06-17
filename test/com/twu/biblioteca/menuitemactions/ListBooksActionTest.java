package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListBooksActionTest {
    @Mock
    private ItemController itemControllerStub;
    @Mock
    private Section sectionStub;

    @Test
    public void shouldBeAbleToInteractWithTheItemControllerToDisplayBookDetails() {
        ListBooksAction listBooksAction = new ListBooksAction(itemControllerStub, sectionStub);
        listBooksAction.performAction();

        verify(itemControllerStub).listAvailableItems(sectionStub);
    }
}
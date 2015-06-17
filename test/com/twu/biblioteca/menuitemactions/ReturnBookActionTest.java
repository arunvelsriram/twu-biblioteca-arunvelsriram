package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.constants.Constants.BOOK_RETURN_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.BOOK_RETURN_SUCCESS_MESSAGE;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookActionTest {
    @Mock
    private ItemController itemControllerStub;
    @Mock
    private Section sectionStub;

    @Test
    public void shouldBeAbleToInteractWithTheItemControllerToReturnABook() {
        ReturnBookAction returnBookAction = new ReturnBookAction(itemControllerStub, sectionStub);
        returnBookAction.performAction();

        verify(itemControllerStub).returnAnItem(sectionStub, BOOK_RETURN_SUCCESS_MESSAGE, BOOK_RETURN_FAILURE_MESSAGE);
    }
}
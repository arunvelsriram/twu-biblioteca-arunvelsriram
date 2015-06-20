package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.controllers.LoginController;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Section;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.constants.Constants.BOOK_RETURN_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.BOOK_RETURN_SUCCESS_MESSAGE;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookActionTest {
    @Mock
    private ItemController itemControllerStub;
    @Mock
    private Section sectionStub;
    @Mock
    private LoginController loginControllerStub;

    private ReturnBookAction returnBookAction;

    @Before
    public void setUp() {
        returnBookAction = new ReturnBookAction(itemControllerStub, sectionStub, loginControllerStub);
    }


    @Test
    public void shouldBeAbleToInteractWithItemControllerToSearchForIssuedBooks() {
        returnBookAction.performAction();

        verify(itemControllerStub).searchIssuedItems(sectionStub);
    }

    @Test
    public void shouldBeAbleToReturnFirstItemInTheListSinceTheListWillBeAlwaysOfLengthOneDueToUniqueTitle() {
        List<Item> issuedItems = new ArrayList<>();
        issuedItems.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        when(itemControllerStub.searchIssuedItems(sectionStub))
                .thenReturn(issuedItems);

        returnBookAction.performAction();

        verify(itemControllerStub, times(1)).returnAnItem(sectionStub, issuedItems.get(0));
    }

    @Test
    public void shouldBeAbleToPassSuccessfulReturnMessage() {
        List<Item> issuedItems = new ArrayList<>();
        issuedItems.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        when(itemControllerStub.searchIssuedItems(sectionStub))
                .thenReturn(issuedItems);

        returnBookAction.performAction();

        verify(itemControllerStub, times(1)).result(BOOK_RETURN_SUCCESS_MESSAGE);
    }

    @Test
    public void shouldBeAbleToPassUnSuccessfulCheckoutMessage() {
        List<Item> availableItems = new ArrayList<>();
        when(itemControllerStub.searchIssuedItems(sectionStub))
                .thenReturn(availableItems);

        returnBookAction.performAction();

        verify(itemControllerStub, times(1)).result(BOOK_RETURN_FAILURE_MESSAGE);
    }
}
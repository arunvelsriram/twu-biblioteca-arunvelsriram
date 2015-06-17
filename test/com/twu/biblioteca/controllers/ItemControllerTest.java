package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.views.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.constants.Constants.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
    @Mock
    private View viewStub;
    @Mock
    private Section sectionStub;

    private ItemController itemController;

    @Before
    public void setUp() {
        itemController = new ItemController(viewStub);
    }

    @Test
    public void shouldBeAbleToDisplayTheAvailableItemsThroughTheView() {
        when(sectionStub.availableItems())
                .thenReturn("List of Items");
        itemController.listAvailableItems(sectionStub);

        verify(viewStub).write(sectionStub.availableItems());
    }

    @Test
    public void shouldBeAbleToReadItemNameInputFromTheUserThroughTheView() {
        itemController.checkoutAnItem(sectionStub, BOOK_CHECKOUT_SUCCESS_MESSAGE, BOOK_CHECKOUT_FAILURE_MESSAGE);

        verify(viewStub).read();
    }

    @Test
    public void shoulBeAbleToCheckoutAnItemThroughTheCorrespondingSection() {
        when(viewStub.read())
                .thenReturn("Item name");
        itemController.checkoutAnItem(sectionStub, BOOK_CHECKOUT_SUCCESS_MESSAGE, BOOK_CHECKOUT_FAILURE_MESSAGE);

        verify(sectionStub).checkoutItem("Item name", BOOK_CHECKOUT_SUCCESS_MESSAGE, BOOK_CHECKOUT_FAILURE_MESSAGE);
    }

    @Test
    public void shoulBeAbleToReturnAnItemThroughTheCorrespondingSection() {
        when(viewStub.read())
                .thenReturn("Item name");
        itemController.returnAnItem(sectionStub, MOVIE_RETURN_SUCCESS_MESSAGE, MOVIE_RETURN_FAILURE_MESSAGE);

        verify(sectionStub).returnItem("Item name", MOVIE_RETURN_SUCCESS_MESSAGE, MOVIE_RETURN_FAILURE_MESSAGE);
    }
}
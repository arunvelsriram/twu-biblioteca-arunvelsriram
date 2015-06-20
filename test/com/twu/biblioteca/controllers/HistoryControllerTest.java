package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.CheckoutHistory;
import com.twu.biblioteca.views.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HistoryControllerTest {
    @Mock
    private CheckoutHistory checkoutHistoryStub;
    @Mock
    private View viewStub;

    private HistoryController historyController;

    @Before
    public void setUp() {
        historyController = new HistoryController(checkoutHistoryStub, viewStub);
    }

    @Test
    public void shouldBeAbleToShowTheCheckoutHistoryThroughTheView() {
        when(checkoutHistoryStub.toString())
                .thenReturn("History");
        historyController.showHistory();

        verify(viewStub).write("History");
    }
}
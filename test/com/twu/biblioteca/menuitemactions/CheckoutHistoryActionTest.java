package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.HistoryController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutHistoryActionTest {
    @Mock
    private HistoryController historyControllerStub;

    @Test
    public void shouldBeAbleToShowTheHistoryThroughTheController() {
        CheckoutHistoryAction checkoutHistoryAction = new CheckoutHistoryAction(historyControllerStub);
        checkoutHistoryAction.performAction();

        verify(historyControllerStub).showHistory();
    }
}
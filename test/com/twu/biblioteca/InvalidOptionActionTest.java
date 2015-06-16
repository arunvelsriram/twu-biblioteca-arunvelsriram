package com.twu.biblioteca;

import com.twu.biblioteca.views.View;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class InvalidOptionActionTest {
    @Mock
    private View viewStub;

    @Test
    public void shouldInvokeInvalidOptionOnMenuController() throws Exception {
        InvalidOptionAction invalidOptionAction = new InvalidOptionAction(viewStub);
        invalidOptionAction.performAction();

        verify(viewStub).write("Select a valid option!");
    }
}
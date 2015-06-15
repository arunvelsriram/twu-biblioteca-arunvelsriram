package com.twu.biblioteca;

import com.twu.biblioteca.controllers.MenuController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class InvalidOptionActionTest {
    @Mock
    private MenuController menuControllerStub;

    @Test
    public void shouldInvokeInvalidOptionOnMenuController() throws Exception {
        InvalidOptionAction invalidOptionAction = new InvalidOptionAction(menuControllerStub);
        invalidOptionAction.performAction();

        verify(menuControllerStub).invalidOption();
    }
}
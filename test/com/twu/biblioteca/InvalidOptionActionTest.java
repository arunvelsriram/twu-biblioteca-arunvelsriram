package com.twu.biblioteca;

import com.twu.biblioteca.views.MenuView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InvalidOptionActionTest {
    @Mock
    private MenuView mockMenuView;

    @Test
    public void shouldInvokeWriteMethodOfMenuViewToDisplayErrorMessage() throws Exception {
        MenuItemAction menuItemAction = new InvalidOptionAction(mockMenuView);
        menuItemAction.performAction();

        Mockito.verify(mockMenuView).write(Matchers.any(String.class));
    }
}
package com.twu.biblioteca;

import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.models.MenuItem;
import com.twu.biblioteca.views.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuControllerTest {
    @Mock
    private Menu menuStub;
    @Mock
    private View viewStub;
    @Mock
    private MenuItem menuItemStub;

    private MenuController menuController;

    @Before
    public void setUp() throws Exception {
        menuController = new MenuController(menuStub, viewStub);
    }

    @Test
    public void shouldDelegateToMenuItemOnValidMenuOption() throws Exception {
        when(viewStub.read())
                .thenReturn(1);
        when(menuStub.menuItem(1))
                .thenReturn(menuItemStub);
        menuController.chooseOption();

        verify(menuItemStub).performAction();
    }

    @Test
    public void shouldPrintErrorMessageThroughViewOnInvalidMenuOption() throws Exception {
        when(viewStub.read())
                .thenReturn(10);
        when(menuStub.menuItem(10))
                .thenReturn(null);
        menuController.chooseOption();

        verify(viewStub).write("Select a valid option!");
    }

    @Test
    public void shouldSentMenuItemsToViewForDisplaying() throws Exception {
        when(menuStub.toString())
                .thenReturn("Menu");
        menuController.showMenu();

        verify(viewStub).write(menuStub.toString());
    }
}
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
    private Menu mockMenu;
    @Mock
    private View mockView;
    @Mock
    private MenuItem mockMenuItem;

    private MenuController menuController;

    @Before
    public void setUp() throws Exception {
        menuController = new MenuController(mockMenu, mockView);
    }

    @Test
    public void shouldDelegateToMenuItemOnValidMenuOption() throws Exception {
        when(mockView.read())
                .thenReturn(1);
        when(mockMenu.menuItem(1))
                .thenReturn(mockMenuItem);
        menuController.chooseOption();

        verify(mockMenuItem).performAction();
    }

    @Test
    public void shouldPrintErrorMessageThroughViewOnInvalidMenuOption() throws Exception {
        when(mockView.read())
                .thenReturn(10);
        when(mockMenu.menuItem(10))
                .thenReturn(null);
        menuController.chooseOption();

        verify(mockView).write("Select a valid option!");
    }

    @Test
    public void shouldSentMenuItemsToViewForDisplaying() throws Exception {
        when(mockMenu.toString())
                .thenReturn("Menu");
        menuController.showMenu();

        verify(mockView).write(mockMenu.toString());
    }
}
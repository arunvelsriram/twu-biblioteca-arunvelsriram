package com.twu.biblioteca.controllers;

import com.twu.biblioteca.InvalidOptionAction;
import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.models.MenuItem;
import com.twu.biblioteca.views.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
    @Mock
    private InvalidOptionAction invalidOptionActionStub;

    private MenuController menuController;

    @Before
    public void setUp() throws Exception {
        menuController = new MenuController(menuStub, viewStub);
    }

    @Test
    public void shouldReturnTrueOnChoosingManuOptionsOtherThanQuit() throws Exception {
        when(viewStub.readInt())
                .thenReturn(1);
        when(menuStub.menuItem(1))
                .thenReturn(menuItemStub);
        when(menuItemStub.isExit())
                .thenReturn(false);

        boolean actual = menuController.chooseOption();

        assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseWhenUserSelectsQuitOption() throws Exception {
        when(viewStub.readInt())
                .thenReturn(3);
        when(menuStub.menuItem(3))
                .thenReturn(menuItemStub);
        when(menuItemStub.isExit())
                .thenReturn(true);

        boolean actual = menuController.chooseOption();

        assertFalse(actual);
    }

    @Test
    public void shouldBeAbleToPrintAMessageThroughTheView() throws Exception {
        menuController.invalidOption();

        verify(viewStub).write("Select a valid option!");
    }
}
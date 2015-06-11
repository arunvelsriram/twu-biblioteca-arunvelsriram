package com.twu.biblioteca;

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

    private MenuController menuController;

    @Before
    public void setUp() throws Exception {
        menuController = new MenuController(menuStub, viewStub);
    }

    @Test
    public void shouldReturnTrueOnValidUserInput() throws Exception {
        when(viewStub.read())
                .thenReturn(1);
        when(menuStub.menuItem(1))
                .thenReturn(menuItemStub);

        boolean actual = menuController.chooseOption();

        assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseOnValidUserInput() throws Exception {
        when(viewStub.read())
                .thenReturn(10);
        when(menuStub.menuItem(10))
                .thenReturn(null);

        boolean actual = menuController.chooseOption();

        assertFalse(actual);
    }

    @Test
    public void shouldSentMenuItemsToViewForDisplaying() throws Exception {
        when(menuStub.toString())
                .thenReturn("Menu");
        menuController.showMenu();

        verify(viewStub).write(menuStub.toString());
    }
}
package com.twu.biblioteca;

import com.twu.biblioteca.models.Menu;
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

    private MenuController menuController;

    @Before
    public void setUp() throws Exception {
        menuController = new MenuController(mockMenu, mockView);
    }

    @Test
    public void shouldSentMenuItemsToViewForDisplaying() throws Exception {
        when(mockMenu.toString())
                .thenReturn("Menu");
        menuController.showMenu();

        verify(mockView).write(mockMenu.toString());
    }
}
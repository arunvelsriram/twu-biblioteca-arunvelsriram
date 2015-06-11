package com.twu.biblioteca;

import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.views.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {
    @Mock
    private View mockView;
    @Mock
    private Books mockBooks;
    @Mock
    private Menu mockMenu;
    @Mock
    private MenuController mockMenuController;
    @Mock
    private BooksController mockBooksController;

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() throws Exception {
        bibliotecaApp = new BibliotecaApp(mockView, mockBooks, mockMenu, mockMenuController, mockBooksController);
    }

    @Test
    public void shouldDisplayAWelcomeMessageThroughTheView() throws Exception {
        bibliotecaApp.start();

        verify(mockView).write("***Welcome to Biblioteca***");
    }

    @Test
    public void shouldInteractWithControllerToDisplayMenuInTheView() throws Exception {
        bibliotecaApp.start();

        verify(mockMenuController).showMenu();
    }
}
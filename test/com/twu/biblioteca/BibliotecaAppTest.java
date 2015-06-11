package com.twu.biblioteca;

import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.views.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {
    @Mock
    private View viewStub;
    @Mock
    private Books booksStub;
    @Mock
    private Menu menuStub;
    @Mock
    private MenuController menuControllerStub;
    @Mock
    private BooksController booksControllerStub;

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() throws Exception {
        bibliotecaApp = new BibliotecaApp(viewStub, booksStub, menuStub, menuControllerStub, booksControllerStub);
    }

    @Test
    public void shouldDisplayAWelcomeMessageThroughTheView() throws Exception {
        bibliotecaApp.start();

        verify(viewStub).write("***Welcome to Biblioteca***");
    }

    @Test
    public void shouldInteractWithControllerToDisplayMenuInTheView() throws Exception {
        bibliotecaApp.start();

        verify(menuControllerStub).showMenu();
    }

    @Test
    public void shouldInteractWithControllerToChooseAnOption() throws Exception {
        when(menuControllerStub.chooseOption())
                .thenReturn(true, false);
        bibliotecaApp.start();

        verify(menuControllerStub, times(2)).chooseOption();
    }
}
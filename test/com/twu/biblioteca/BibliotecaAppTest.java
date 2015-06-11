package com.twu.biblioteca;

import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.views.View;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {
    @Mock
    private View mockView;
    @Mock
    private Books mockBooks;
    @Mock
    private Menu mockMenu;

    @Test
    public void shouldDiplayAWelcomeMessageThroughView() throws Exception {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(mockView, mockBooks, mockMenu);
        bibliotecaApp.start();

        Mockito.verify(mockView).write("***Welcome to Biblioteca***");
    }
}
package com.twu.biblioteca;

import com.twu.biblioteca.views.BibliotecaAppView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {
    @Mock
    BibliotecaAppView mockBibliotecaAppView;

    @Test
    public void shouldInvokeAMethodOnViewToDisplayWelcomeMessage() throws Exception {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(mockBibliotecaAppView);
        bibliotecaApp.start();

        Mockito.verify(mockBibliotecaAppView).display("***Welcome to Biblioteca***");
    }
}
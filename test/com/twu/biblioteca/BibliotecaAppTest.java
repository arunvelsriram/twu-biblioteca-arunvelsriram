package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;

    @Mock
    private OutputHandler outputHandlerStub;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bibliotecaApp = new BibliotecaApp(outputHandlerStub);
    }

    @Test
    public void shouldInvokeAMethodOnOutputHandlerToDisplayWelcomeMessage() {
        bibliotecaApp.start();

        Mockito.verify(outputHandlerStub).welcomeMessage();
    }
}
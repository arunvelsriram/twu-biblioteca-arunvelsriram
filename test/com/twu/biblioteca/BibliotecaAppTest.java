package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;

    @Mock
    private InputOutputHandler inputOutputHandlerStub;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bibliotecaApp = new BibliotecaApp(inputOutputHandlerStub);
    }

    @Test
    public void shouldUseMethodsOnInputOutputHandlerToDisplayWelcomeMessage() {
        bibliotecaApp.start();

        Mockito.verify(inputOutputHandlerStub).welcomeMessage();
    }

    @Test
    public void shouldUseMethodsOnInputOutputHandlerToDisplayAMenuWithListOfOptions() {
        bibliotecaApp.start();

        Mockito.verify(inputOutputHandlerStub).listOptions(Matchers.any(Menu.class));
    }
}
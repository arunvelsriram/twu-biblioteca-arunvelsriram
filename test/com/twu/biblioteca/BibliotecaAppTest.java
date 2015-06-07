package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

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

        verify(inputOutputHandlerStub).welcomeMessage();
    }

    @Test
    public void shouldUseMethodsOnInputOutputHandlerToDisplayAMenuWithListOfOptions() {
        bibliotecaApp.start();

        verify(inputOutputHandlerStub).listOptions(Matchers.any(Menu.class));
    }

    @Test
    public void shouldUseMethodsOnInputOutputHandlerToGetAMenuOptionFromTheUser() {
        bibliotecaApp.start();

        verify(inputOutputHandlerStub).readMenuOption();
    }
}
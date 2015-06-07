package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {
    @Mock
    BibliotecaApp.FactoryHelper mockFactoryHelper;
    @Mock
    private InputOutputHandler mockInputOutputHandler;
    @Mock
    private Menu mockMenu;

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bibliotecaApp = new BibliotecaApp(mockFactoryHelper);
    }

    @Test
    public void shouldUseMethodsOnInputOutputHandlerToDisplayWelcomeMessage() {
        givenWhen();

        verify(mockInputOutputHandler).welcomeMessage();
    }

    @Test
    public void shouldUseMethodsOnInputOutputHandlerToDisplayAMenuWithListOfOptions() {
        givenWhen();

        verify(mockInputOutputHandler).listOptions(Matchers.any(Menu.class));
    }

    @Test
    public void shouldUseMethodsOnInputOutputHandlerToGetAMenuOptionFromTheUser() {
        givenWhen();

        verify(mockInputOutputHandler).readMenuOption();
    }

    @Test
    public void shouldBeAbleToChooseAnOptionByPassingTheOptionGivenByTheUser() {
        givenWhen();

        verify(mockMenu).choose(Matchers.any(Integer.class));
    }

    private void givenWhen() {
        when(mockFactoryHelper.makeInputOutputHandler())
                .thenReturn(mockInputOutputHandler);
        when(mockFactoryHelper.makeMenu())
                .thenReturn(mockMenu);

        bibliotecaApp.start();
    }
}
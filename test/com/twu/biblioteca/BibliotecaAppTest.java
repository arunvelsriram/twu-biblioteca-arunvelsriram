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
    private InputOutputHandler inputOutputHandlerStub;
    @Mock
    private Menu menuStub;

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bibliotecaApp = new BibliotecaApp(mockFactoryHelper);
    }

    @Test
    public void shouldUseMethodsOnInputOutputHandlerToDisplayWelcomeMessage() {
        givenWhen();

        verify(inputOutputHandlerStub).welcomeMessage();
    }

    @Test
    public void shouldUseMethodsOnInputOutputHandlerToDisplayAMenuWithListOfOptions() {
        givenWhen();

        verify(inputOutputHandlerStub).listOptions(Matchers.any(Menu.class));
    }

    @Test
    public void shouldUseMethodsOnInputOutputHandlerToGetAMenuOptionFromTheUser() {
        givenWhen();

        verify(inputOutputHandlerStub).readMenuOption();
    }

    @Test
    public void shouldBeAbleToChooseAnOptionByPassingTheOptionGivenByTheUser() {
        givenWhen();

        verify(menuStub).choose(Matchers.any(Integer.class));
    }

    private void givenWhen() {
        when(mockFactoryHelper.makeInputOutputHandler())
                .thenReturn(inputOutputHandlerStub);
        when(mockFactoryHelper.makeMenu())
                .thenReturn(menuStub);

        bibliotecaApp.start();
    }
}
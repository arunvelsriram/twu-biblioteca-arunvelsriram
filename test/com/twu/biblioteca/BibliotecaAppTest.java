package com.twu.biblioteca;

import com.twu.biblioteca.controllers.MenuController;
import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.views.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {
    @Mock
    private View viewStub;
    @Mock
    private Section sectionStub;
    @Mock
    private Menu menuStub;
    @Mock
    private MenuController menuControllerStub;

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() {
        bibliotecaApp = new BibliotecaApp(viewStub, sectionStub, menuStub, menuControllerStub);
    }

    @Test
    public void shouldDisplayAWelcomeMessageThroughTheView() {
        bibliotecaApp.start();

        verify(viewStub).write("***Welcome to Biblioteca***");
    }

    @Test
    public void shouldInteractWithControllerToDisplayMenuInTheView() {
        bibliotecaApp.start();

        verify(menuControllerStub).showMenu();
    }

    @Test
    public void shouldInteractWithControllerToChooseAnOption() {
        when(menuControllerStub.chooseOption())
                .thenReturn(true, false);
        bibliotecaApp.start();

        verify(menuControllerStub, times(2)).chooseOption();
    }
}
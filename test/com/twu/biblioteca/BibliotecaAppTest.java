package com.twu.biblioteca;

import com.twu.biblioteca.controllers.MenuDispatcher;
import com.twu.biblioteca.models.Guest;
import com.twu.biblioteca.models.Section;
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
    private View viewStub;
    @Mock
    private Section sectionStub;
    @Mock
    private MenuDispatcher menuDispatcherStub;
    @Mock
    private Guest guestStub;

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() {
        bibliotecaApp = new BibliotecaApp(viewStub, sectionStub, menuDispatcherStub, guestStub);
    }

    @Test
    public void shouldDisplayAWelcomeMessageThroughTheView() {
        bibliotecaApp.start();

        verify(viewStub).write("***Welcome to Biblioteca***");
    }

    @Test
    public void shouldInteractMenuDispatcherAsGuestUser() {
        bibliotecaApp.start();

        verify(menuDispatcherStub).visit(guestStub);
    }
}
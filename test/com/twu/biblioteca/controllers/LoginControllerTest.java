package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.User;
import com.twu.biblioteca.models.Users;
import com.twu.biblioteca.views.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.biblioteca.constants.Constants.LIBRARY_NUMBER_PROMPT_MESSAGE;
import static com.twu.biblioteca.constants.Constants.PASSWORD_PROMPT_MESSAGE;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
    @Mock
    private View viewStub;
    @Mock
    private Users usersStub;
    @Mock
    private MenuDispatcher menuDispatcherStub;
    @Mock
    private User userStub;

    private LoginController loginController;

    @Before
    public void setUp() {
        loginController = new LoginController(usersStub, viewStub, menuDispatcherStub);
    }

    @Test
    public void shouldBeAbleToPrintPromptMessageForLibraryNumber() {
        when(viewStub.read())
                .thenReturn("B1101", "pass");
        when(usersStub.authenticate("B1101", "pass"))
                .thenReturn(userStub);
        when(userStub.statusMessage())
                .thenReturn("Login failed!");
        loginController.login();

        verify(viewStub).write(LIBRARY_NUMBER_PROMPT_MESSAGE);
    }

    @Test
    public void shouldBeAbleToPrintPromptMessageForPassword() {
        when(viewStub.read())
                .thenReturn("B1101", "pass");
        when(usersStub.authenticate("B1101", "pass"))
                .thenReturn(userStub);
        when(userStub.statusMessage())
                .thenReturn("Login failed!");
        loginController.login();

        verify(viewStub).write(PASSWORD_PROMPT_MESSAGE);
    }

    @Test
    public void shouldBeAbleToReadLibraryNumberAndPasswordThroughTheView() {
        when(viewStub.read())
                .thenReturn("B1101", "pass");
        when(usersStub.authenticate("B1101", "pass"))
                .thenReturn(userStub);
        when(userStub.statusMessage())
                .thenReturn("Login failed!");
        loginController.login();

        verify(viewStub, times(2)).read();
    }

    @Test
    public void shouldInteractWithUserModelToAuthenticateTheUser() {
        when(viewStub.read())
                .thenReturn("B1101", "pass");
        when(usersStub.authenticate("B1101", "pass"))
                .thenReturn(userStub);
        when(userStub.statusMessage())
                .thenReturn("Login failed!");
        loginController.login();

        verify(usersStub).authenticate("B1101", "pass");
    }

    @Test
    public void shouldBeAbleToGetLoginStatusMessage() {
        when(viewStub.read())
                .thenReturn("B1101", "pass");
        when(usersStub.authenticate("B1101", "pass"))
                .thenReturn(userStub);
        when(userStub.statusMessage())
                .thenReturn("Login failed!");
        loginController.login();

        verify(userStub).statusMessage();
    }

    @Test
    public void shouldBeAbleToWriteLoginStatusMessageToTheView() {
        when(viewStub.read())
                .thenReturn("B1101", "pass");
        when(usersStub.authenticate("B1101", "pass"))
                .thenReturn(userStub);
        when(userStub.statusMessage())
                .thenReturn("Login failed!");
        loginController.login();

        verify(viewStub).write(userStub.statusMessage());
    }
}
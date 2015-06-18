package com.twu.biblioteca.controllers;

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

    private LoginController loginController;

    @Before
    public void setUp() throws Exception {
        loginController = new LoginController(usersStub, viewStub);
    }

    @Test
    public void shouldBeAbleToPrintPromptMessageForLibraryNumber() {
        loginController.login();

        verify(viewStub).write(LIBRARY_NUMBER_PROMPT_MESSAGE);
    }

    @Test
    public void shouldBeAbleToPrintPromptMessageForPassword() {
        loginController.login();

        verify(viewStub).write(PASSWORD_PROMPT_MESSAGE);
    }

    @Test
    public void shouldBeAbleToReadLibraryNumberAndPasswordThroughTheView() {
        loginController.login();

        verify(viewStub, times(2)).read();
    }

    @Test
    public void shouldInteractWithUserModelToAuthenticateTheUser() {
        when(viewStub.read())
                .thenReturn("B1101", "pass");
        loginController.login();

        verify(usersStub).authenticate("B1101", "pass");
    }
}
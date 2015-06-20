package com.twu.biblioteca.controllers;

import com.twu.biblioteca.LoginListener;
import com.twu.biblioteca.models.Guest;
import com.twu.biblioteca.models.Librarian;
import com.twu.biblioteca.models.Member;
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
    private Guest guestStub;
    @Mock
    private Member memberStub;
    @Mock
    private Librarian librarianStub;
    @Mock
    private LoginListener loginListenerStub;

    private LoginController loginController;

    @Before
    public void setUp() {
        loginController = new LoginController(usersStub, viewStub);
        loginController.addLoginListener(loginListenerStub);
    }

    @Test
    public void shouldBeAbleToPrintPromptMessageForLibraryNumber() {
        when(viewStub.read())
                .thenReturn("B1101", "pass");
        when(usersStub.authenticate("B1101", "pass"))
                .thenReturn(guestStub);
        when(guestStub.statusMessage())
                .thenReturn("Login failed!");
        loginController.login();

        verify(viewStub).write(LIBRARY_NUMBER_PROMPT_MESSAGE);
    }

    @Test
    public void shouldBeAbleToPrintPromptMessageForPassword() {
        when(viewStub.read())
                .thenReturn("B1101", "pass");
        when(usersStub.authenticate("B1101", "pass"))
                .thenReturn(guestStub);
        when(guestStub.statusMessage())
                .thenReturn("Login failed!");
        loginController.login();

        verify(viewStub).write(PASSWORD_PROMPT_MESSAGE);
    }

    @Test
    public void shouldBeAbleToReadLibraryNumberAndPasswordThroughTheView() {
        when(viewStub.read())
                .thenReturn("B1101", "pass");
        when(usersStub.authenticate("B1101", "pass"))
                .thenReturn(guestStub);
        when(guestStub.statusMessage())
                .thenReturn("Login failed!");
        loginController.login();

        verify(viewStub, times(2)).read();
    }

    @Test
    public void shouldInteractWithUserModelToAuthenticateTheUser() {
        when(viewStub.read())
                .thenReturn("B1101", "pass");
        when(usersStub.authenticate("B1101", "pass"))
                .thenReturn(guestStub);
        when(guestStub.statusMessage())
                .thenReturn("Login failed!");
        loginController.login();

        verify(usersStub).authenticate("B1101", "pass");
    }

    @Test
    public void shouldBeAbleToGetLoginStatusMessage() {
        when(viewStub.read())
                .thenReturn("B1101", "pass");
        when(usersStub.authenticate("B1101", "pass"))
                .thenReturn(guestStub);
        when(guestStub.statusMessage())
                .thenReturn("Login failed!");
        loginController.login();

        verify(guestStub).statusMessage();
    }

    @Test
    public void shouldBeAbleToWriteLoginStatusMessageToTheView() {
        when(viewStub.read())
                .thenReturn("B1101", "pass");
        when(usersStub.authenticate("B1101", "pass"))
                .thenReturn(guestStub);
        when(guestStub.statusMessage())
                .thenReturn("Login failed!");
        loginController.login();

        verify(viewStub).write(guestStub.statusMessage());
    }

    @Test
    public void shouldBeAbleToUpdateTheUserInTheApp() {
        when(viewStub.read())
                .thenReturn("B1101", "pass");
        when(usersStub.authenticate("B1101", "pass"))
                .thenReturn(guestStub);
        when(guestStub.statusMessage())
                .thenReturn("Login failed!");
        loginController.login();

        verify(loginListenerStub).update(guestStub);
    }

    @Test
    public void shouldBeAbleToUpdateTheUserInTheAppWhenMemberLogsIn() {
        when(viewStub.read())
                .thenReturn("B1102", "password");
        when(usersStub.authenticate("B1102", "password"))
                .thenReturn(memberStub);
        when(memberStub.statusMessage())
                .thenReturn("Hi! You are logged in as Member.");
        loginController.login();

        verify(loginListenerStub).update(memberStub);
    }

    @Test
    public void shouldBeAbleToUpdateTheUserInTheAppWhenLibrarianLogsIn() {
        when(viewStub.read())
                .thenReturn("B1104", "pword");
        when(usersStub.authenticate("B1104", "pword"))
                .thenReturn(librarianStub);
        when(librarianStub.statusMessage())
                .thenReturn("Hi! You are logged in as Librarian.");
        loginController.login();

        verify(loginListenerStub).update(librarianStub);
    }

    @Test
    public void shouldBeAbleToDisplayUserInformationOnceHeLogsIn() {
        when(viewStub.read())
                .thenReturn("B1104", "pword");
        when(usersStub.authenticate("B1104", "pword"))
                .thenReturn(librarianStub);
        when(librarianStub.statusMessage())
                .thenReturn("Hi! You are logged in as Librarian.");
        when(librarianStub.toString())
                .thenReturn("User details");
        loginController.login();

        verify(viewStub).write(librarianStub.toString());
    }
}
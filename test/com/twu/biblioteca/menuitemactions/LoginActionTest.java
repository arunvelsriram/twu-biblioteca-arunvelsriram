package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.LoginController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoginActionTest {
    @Mock
    private LoginController loginControllerStub;

    @Test
    public void shouldBeAbleToPerformLoginActionThroughTheLoginController() {
        LoginAction loginAction = new LoginAction(loginControllerStub);
        loginAction.performAction();

        verify(loginControllerStub).login();
    }
}
package com.twu.biblioteca;

import com.twu.biblioteca.views.View;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QuitActionTest {
    @Mock
    private View mockView;
    @Rule
    public final ExpectedSystemExit expectedSystemExit = ExpectedSystemExit.none();

    @Test
    public void shouldBeAbleToQuitTheAppWhenUserChoosesQuitOption() throws Exception {
        QuitAction quitAction = new QuitAction(mockView);
        expectedSystemExit.expectSystemExitWithStatus(0);
        quitAction.performAction();

        Mockito.verify(mockView).write(Matchers.any(String.class));
    }
}
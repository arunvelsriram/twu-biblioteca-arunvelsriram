package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QuitActionTest {
    @Rule
    public final ExpectedSystemExit expectedSystemExit = ExpectedSystemExit.none();

    @Test
    public void shouldBeAbleToQuitTheAppWhenUserChoosesQuitOption() throws Exception {
        QuitAction quitAction = new QuitAction();
        expectedSystemExit.expectSystemExitWithStatus(0);
        quitAction.performAction();
    }
}
package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.views.View;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class QuitActionTest {
    @Mock
    private View viewStub;
    @Rule
    public final ExpectedSystemExit expectedSystemExit = ExpectedSystemExit.none();

    @Test
    public void shouldBeAbleToWriteToTheViewAndQuitTheApp() {
        QuitAction quitAction = new QuitAction(viewStub);
        expectedSystemExit.expectSystemExit();

        quitAction.performAction();

        verify(viewStub).write("Bye!");
    }
}
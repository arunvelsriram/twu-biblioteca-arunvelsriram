package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    @Mock
    private MenuItemActionListenerImpl menuItemActionListenerStub;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldBeAbleToReturnAvailableOptions() {
        Menu menu = new Menu(new MenuItemActionListenerImpl());

        String actualOptions = menu.toString();

        assertThat(actualOptions, is(equalTo("1. List Books\nEnter your choice...")));
    }

    @Test
    public void shouldBeAbleToInvokeActionPerformedByPassingAValidOption() throws Exception {
        int option = 1;
        Menu menu = new Menu(menuItemActionListenerStub);

        menu.choose(option);

        Mockito.verify(menuItemActionListenerStub).actionPerformed(option);
    }

    @Test
    public void shouldBeAbleToInvokeActionPerformedByPassingAnInvalidOptionWhenUserChoosesAnInvalidOption() throws Exception {
        int option = 10;
        Menu menu = new Menu(menuItemActionListenerStub);

        menu.choose(option);

        option = -1;
        Mockito.verify(menuItemActionListenerStub).actionPerformed(option);
    }
}
package com.twu.biblioteca.models;

import com.twu.biblioteca.ListBooksAction;
import com.twu.biblioteca.MenuItemAction;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuItemTest {
    @Mock
    private View mockView;
    @Mock
    private Books mockBooks;
    @Mock
    private MenuItemAction mockMenuItemAction;

    @Test
    public void shouldBeAbleToReturnAMenuItem() throws Exception {
        MenuItem menuItem = new MenuItem("List Books", new ListBooksAction(mockView, mockBooks));
        when(mockView.toString()).thenReturn("List Books");

        String actualMenuItem = menuItem.toString();

        assertThat(actualMenuItem, is(equalTo("List Books")));
    }

    @Test
    public void shouldBeAbleToPerformAnActionByInvokingMethodOnMenuItemAction() throws Exception {
        MenuItem menuItem = new MenuItem("List Books", mockMenuItemAction);
        menuItem.performAction();

        Mockito.verify(mockMenuItemAction).performAction();
    }

    @Test
    public void equalityShouldSatisfyReflexivity() {
        MenuItem menuItemOne = new MenuItem("List Books", mockMenuItemAction);

        assertThat(menuItemOne, is(equalTo(menuItemOne)));
    }

    @Test
    public void equalityShouldSatisfySymmetricity() {
        MenuItem menuItemOne = new MenuItem("List Books", mockMenuItemAction);
        MenuItem menuItemTwo = new MenuItem("List Books", mockMenuItemAction);

        assertThat(menuItemOne, is(equalTo(menuItemTwo)));
        assertThat(menuItemTwo, is(equalTo(menuItemOne)));
    }

    @Test
    public void equalityShouldSatisfyTransitivity() {
        MenuItem menuItemOne = new MenuItem("List Books", mockMenuItemAction);
        MenuItem menuItemTwo = new MenuItem("List Books", mockMenuItemAction);
        MenuItem menuItemThree = new MenuItem("List Books", mockMenuItemAction);

        assertThat(menuItemOne, is(equalTo(menuItemTwo)));
        assertThat(menuItemTwo, is(equalTo(menuItemThree)));
        assertThat(menuItemOne, is(equalTo(menuItemThree)));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingNull() {
        MenuItem menuItemOne = new MenuItem("List Books", mockMenuItemAction);

        assertFalse(menuItemOne.equals(null));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingOtherObject() {
        MenuItem menuItemOne = new MenuItem("List Books", mockMenuItemAction);

        assertFalse(menuItemOne.equals(new String("Hello, World")));
    }

    @Test
    public void whenTwoObjectsAreEqualThenTheirHashCodeMustBeEqual() {
        MenuItem menuItemOne = new MenuItem("List Books", mockMenuItemAction);
        MenuItem menuItemTwo = new MenuItem("List Books", mockMenuItemAction);

        assertThat(menuItemOne, is(equalTo(menuItemTwo)));
        assertThat(menuItemOne.hashCode(), is(equalTo(menuItemTwo.hashCode())));
    }
}
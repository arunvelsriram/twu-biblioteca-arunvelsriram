package com.twu.biblioteca.models;

import com.twu.biblioteca.controllers.BooksController;
import com.twu.biblioteca.menuitemactions.ListBooksAction;
import com.twu.biblioteca.menuitemactions.MenuItemAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MenuItemTest {
    @Mock
    private Section sectionStub;
    @Mock
    private BooksController booksControllerStub;
    @Mock
    private MenuItemAction menuItemActionStub;

    @Test
    public void shouldBeAbleToReturnMenuItemName() throws Exception {
        MenuItem menuItem = new MenuItem("List Books", new ListBooksAction(booksControllerStub));

        String actualMenuItem = menuItem.toString();

        assertThat(actualMenuItem, is(equalTo("List Books")));
    }

    @Test
    public void shouldBeAbleToPerformAnActionByInvokingMethodOnMenuItemAction() throws Exception {
        MenuItem menuItem = new MenuItem("List Books", menuItemActionStub);
        menuItem.performAction();

        verify(menuItemActionStub).performAction();
    }

    @Test
    public void equalityShouldSatisfyReflexivity() {
        MenuItem menuItemOne = new MenuItem("List Books", menuItemActionStub);

        assertThat(menuItemOne, is(equalTo(menuItemOne)));
    }

    @Test
    public void equalityShouldSatisfySymmetricity() {
        MenuItem menuItemOne = new MenuItem("List Books", menuItemActionStub);
        MenuItem menuItemTwo = new MenuItem("List Books", menuItemActionStub);

        assertThat(menuItemOne, is(equalTo(menuItemTwo)));
        assertThat(menuItemTwo, is(equalTo(menuItemOne)));
    }

    @Test
    public void equalityShouldSatisfyTransitivity() {
        MenuItem menuItemOne = new MenuItem("List Books", menuItemActionStub);
        MenuItem menuItemTwo = new MenuItem("List Books", menuItemActionStub);
        MenuItem menuItemThree = new MenuItem("List Books", menuItemActionStub);

        assertThat(menuItemOne, is(equalTo(menuItemTwo)));
        assertThat(menuItemTwo, is(equalTo(menuItemThree)));
        assertThat(menuItemOne, is(equalTo(menuItemThree)));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingNull() {
        MenuItem menuItemOne = new MenuItem("List Books", menuItemActionStub);

        assertFalse(menuItemOne.equals(null));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingOtherObject() {
        MenuItem menuItemOne = new MenuItem("List Books", menuItemActionStub);

        assertFalse(menuItemOne.equals(new String("Hello, World")));
    }

    @Test
    public void whenTwoObjectsAreEqualThenTheirHashCodeMustBeEqual() {
        MenuItem menuItemOne = new MenuItem("List Books", menuItemActionStub);
        MenuItem menuItemTwo = new MenuItem("List Books", menuItemActionStub);

        assertThat(menuItemOne, is(equalTo(menuItemTwo)));
        assertThat(menuItemOne.hashCode(), is(equalTo(menuItemTwo.hashCode())));
    }

    @Test
    public void shouldReturnFalseForOptionsOtherThanExit() throws Exception {
        MenuItem menuItem = new MenuItem("List Books", menuItemActionStub);

        assertFalse(menuItem.isExit());
    }

    @Test
    public void shouldReturnTrueForExitOption() throws Exception {
        MenuItem menuItem = new MenuItem("Quit", null);

        assertTrue(menuItem.isExit());
    }
}
package com.twu.biblioteca.dispatchers;

import com.twu.biblioteca.controllers.MenuController;
import com.twu.biblioteca.models.Guest;
import com.twu.biblioteca.models.Librarian;
import com.twu.biblioteca.models.Member;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class MenuDispatcherTest {
    @Mock
    private MenuController menuControllerStub;
    @Mock
    private Guest guestStub;
    @Mock
    private Member memberStub;
    @Mock
    private Librarian librarianStub;

    private MenuDispatcher menuDispatcher;

    @Before
    public void setUp() throws Exception {
        menuDispatcher = new MenuDispatcher(menuControllerStub, menuControllerStub, menuControllerStub);
    }

    @Test
    public void shouldBeToAbleShowGuestMenuInfinitely() {
        when(menuControllerStub.chooseOption())
                .thenReturn(true, false);
        menuDispatcher.dispatch(guestStub);

        verify(menuControllerStub, times(2)).chooseOption();
    }

    @Test
    public void shouldBeToAbleChooseAnOptionFromGuestMenuInfinitely() {
        when(menuControllerStub.chooseOption())
                .thenReturn(true, false);
        menuDispatcher.dispatch(guestStub);

        verify(menuControllerStub, times(2)).chooseOption();
    }

    @Test
    public void shouldBeToAbleShowLibrarianMenuInfinitely() {
        when(menuControllerStub.chooseOption())
                .thenReturn(true, false);
        menuDispatcher.dispatch(librarianStub);

        verify(menuControllerStub, times(2)).chooseOption();
    }

    @Test
    public void shouldBeToAbleChooseAnOptionFromLibrarianMenuInfinitely() {
        when(menuControllerStub.chooseOption())
                .thenReturn(true, false);
        menuDispatcher.dispatch(librarianStub);

        verify(menuControllerStub, times(2)).chooseOption();
    }

    @Test
    public void shouldBeToAbleShowMemberMenuInfinitely() {
        when(menuControllerStub.chooseOption())
                .thenReturn(true, false);
        menuDispatcher.dispatch(memberStub);

        verify(menuControllerStub, times(2)).chooseOption();
    }

    @Test
    public void shouldBeToAbleChooseAnOptionFromMemberMenuInfinitely() {
        when(menuControllerStub.chooseOption())
                .thenReturn(true, false);
        menuDispatcher.dispatch(memberStub);

        verify(menuControllerStub, times(2)).chooseOption();
    }
}
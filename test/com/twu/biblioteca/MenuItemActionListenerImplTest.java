package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class MenuItemActionListenerImplTest {
    @Mock
    private MenuItemActionListenerImpl.FactoryHelper mockFactoryHelper;
    @Mock
    private InputOutputHandler inputOutputHandlerStub;
    @Mock
    private Books booksStub;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldBeAbleToPerformDisplayBookListActionOnChoosingListBooksOption() {
        MenuItemActionListener menuItemActionListener = new MenuItemActionListenerImpl(mockFactoryHelper);
        when(mockFactoryHelper.makeInputOutputHandler())
                .thenReturn(inputOutputHandlerStub);
        when(mockFactoryHelper.makeBooks())
                .thenReturn(booksStub);
        menuItemActionListener.actionPerformed(1);

        Mockito.verify(inputOutputHandlerStub).bookDetails(booksStub);
    }

    @Test
    public void shouldBeAbleToPerformDisplayErrorMessageActionOnChoosingAnInvalidOption() throws Exception {
        MenuItemActionListener menuItemActionListener = new MenuItemActionListenerImpl(mockFactoryHelper);
        when(mockFactoryHelper.makeInputOutputHandler())
                .thenReturn(inputOutputHandlerStub);
        menuItemActionListener.actionPerformed(-1);

        Mockito.verify(inputOutputHandlerStub).errorMessage();
    }
}
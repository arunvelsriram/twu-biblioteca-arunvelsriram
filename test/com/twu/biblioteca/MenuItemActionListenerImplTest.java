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
    private InputOutputHandler mockInputOutputHandler;
    @Mock
    private Books mockBooks;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldBeAbleToPerformDisplayBookListActionOnChoosingListBooksOption() {
        MenuItemActionListener menuItemActionListener = new MenuItemActionListenerImpl(mockFactoryHelper);
        when(mockFactoryHelper.makeInputOutputHandler())
                .thenReturn(mockInputOutputHandler);
        when(mockFactoryHelper.makeBooks())
                .thenReturn(mockBooks);

        menuItemActionListener.actionPerformed(1);

        Mockito.verify(mockInputOutputHandler).bookDetails(mockBooks);
    }

    @Test
    public void shouldBeAbleToPerformDisplayErrorMessageActionOnChoosingAnInvalidOption() throws Exception {
        MenuItemActionListener menuItemActionListener = new MenuItemActionListenerImpl(mockFactoryHelper);
        when(mockFactoryHelper.makeInputOutputHandler())
                .thenReturn(mockInputOutputHandler);
        
        menuItemActionListener.actionPerformed(-1);

        Mockito.verify(mockInputOutputHandler).errorMessage();
    }
}
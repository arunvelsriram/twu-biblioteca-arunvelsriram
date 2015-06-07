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
    public void shouldBeAbleToPerformAnAction() {
        MenuItemActionListener menuItemActionListener = new MenuItemActionListenerImpl(mockFactoryHelper);
        when(mockFactoryHelper.makeInputOutputHandler())
                .thenReturn(inputOutputHandlerStub);
        when(mockFactoryHelper.makeBooks())
                .thenReturn(booksStub);
        menuItemActionListener.actionPerformed();

        Mockito.verify(inputOutputHandlerStub).bookDetails(booksStub);
    }
}
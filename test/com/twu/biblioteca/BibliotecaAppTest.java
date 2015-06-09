package com.twu.biblioteca;

import com.twu.biblioteca.views.BibliotecaAppView;
import com.twu.biblioteca.views.BooksView;
import com.twu.biblioteca.views.MenuView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {
    @Mock
    private BibliotecaAppView mockBibliotecaAppView;
    @Mock
    private BooksView mockBooksView;
    @Mock
    private MenuView mockMenuView;
    @Mock
    private Books mockBooks;
    @Mock
    private Menu mockMenu;
    @Mock
    private MenuItem mockMenuItem;

    @Test
    public void shouldInvokeASeriesOfMethods() throws Exception {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(mockBibliotecaAppView, mockBooksView, mockMenuView, mockBooks, mockMenu);
        when(mockMenuView.read())
                .thenReturn(1);
        when(mockMenu.menuItem(Matchers.any(Integer.class)))
                .thenReturn(mockMenuItem);
        bibliotecaApp.start();

        Mockito.verify(mockBibliotecaAppView).write("***Welcome to Biblioteca***");
        Mockito.verify(mockMenuView).write();
        Mockito.verify(mockMenuView).read();
        Mockito.verify(mockMenu).menuItem(Matchers.any(Integer.class));
        Mockito.verify(mockMenuItem).performAction();
    }
}
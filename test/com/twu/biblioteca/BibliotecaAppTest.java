package com.twu.biblioteca;

import com.twu.biblioteca.views.BibliotecaAppView;
import com.twu.biblioteca.views.BooksView;
import com.twu.biblioteca.views.MenuView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

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

    @Test
    public void shouldInvokeMethodsOnBibliotecaAppViewBooksViewAndMenuView() throws Exception {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(mockBibliotecaAppView, mockBooksView, mockMenuView, mockBooks, mockMenu);
        bibliotecaApp.start();

        Mockito.verify(mockBibliotecaAppView).display("***Welcome to Biblioteca***");
        Mockito.verify(mockMenuView).display();
    }
}
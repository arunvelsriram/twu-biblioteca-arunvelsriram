package com.twu.biblioteca.models;

import com.twu.biblioteca.controllers.Visitor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GuestTest {
    @Mock
    private Visitor visitorStub;

    private Guest guest;

    @Before
    public void setUp() throws Exception {
        guest = new Guest();
    }

    @Test
    public void shouldBeVisitableByTheMenuDispatcher() {
        guest.accept(visitorStub);

        verify(visitorStub).visit(guest);
    }

    @Test
    public void shouldBeAbleToReturnAStatusMessage() {
        String actualMessage = guest.statusMessage();

        assertThat(actualMessage, is(equalTo("Login failed!")));
    }
}
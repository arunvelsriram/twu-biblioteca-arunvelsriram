package com.twu.biblioteca.models;

import com.twu.biblioteca.dispatchers.Dispatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MemberTest {
    @Mock
    private Dispatcher dispatcherStub;

    private Member member;

    @Before
    public void setUp() {
        member = new Member("B1012", "password", "Arun", "arunvelsriram@gmail.com", "919629722335");
    }

    @Test
    public void shouldBeAbleToIdentifyAValidUser() {
        boolean actual = member.valid("B1012", "password");

        assertTrue(actual);
    }

    @Test
    public void shouldBeAbleToCheckTheUserName() {
        boolean actual = member.valid("B1111", "password");

        assertFalse(actual);
    }

    @Test
    public void shouldBeAbleToCheckThePassword() {
        boolean actual = member.valid("B1012", "pasword");

        assertFalse(actual);
    }

    @Test
    public void shouldBeAbleToCheckBothUserNameAndPassword() {
        boolean actual = member.valid("B1111", "pasword");

        assertFalse(actual);
    }

    @Test
    public void equalityShouldSatisfyReflexivity() {
        Member memberOne = new Member("B1011", "passwd", "Murali", "murali123@gmail.com", "919976767676");

        assertThat(memberOne, is(equalTo(memberOne)));
    }

    @Test
    public void equalityShouldSatisfySymmetricity() {
        Member memberOne = new Member("B1011", "passwd", "Murali", "murali123@gmail.com", "919976767676");
        Member memberTwo = new Member("B1011", "passwd", "Murali", "murali123@gmail.com", "919976767676");

        assertThat(memberOne, is(equalTo(memberTwo)));
        assertThat(memberTwo, is(equalTo(memberOne)));
    }

    @Test
    public void equalityShouldSatisfyTransitivity() {
        Member memberOne = new Member("B1011", "passwd", "Murali", "murali123@gmail.com", "919976767676");
        Member memberTwo = new Member("B1011", "passwd", "Murali", "murali123@gmail.com", "919976767676");
        Member memberThree = new Member("B1011", "passwd", "Murali", "murali123@gmail.com", "919976767676");

        assertThat(memberOne, is(equalTo(memberTwo)));
        assertThat(memberTwo, is(equalTo(memberThree)));
        assertThat(memberOne, is(equalTo(memberThree)));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingNull() {
        Member memberOne = new Member("B1011", "passwd", "Murali", "murali123@gmail.com", "919976767676");

        assertFalse(memberOne.equals(null));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingOtherObject() {
        Member memberOne = new Member("B1011", "passwd", "Murali", "murali123@gmail.com", "919976767676");

        assertFalse(memberOne.equals(new String("Hello, World")));
    }

    @Test
    public void whenTwoObjectsAreEqualThenTheirHashCodeMustBeEqual() {
        Member guest = new Member("B1011", "passwd", "Murali", "murali123@gmail.com", "919976767676");
        Member memberTwo = new Member("B1011", "passwd", "Murali", "murali123@gmail.com", "919976767676");

        assertThat(guest, is(equalTo(memberTwo)));
        assertThat(guest.hashCode(), is(equalTo(memberTwo.hashCode())));
    }

    @Test
    public void shouldBeVisitableByTheMenuDispatcher() {
        member.accept(dispatcherStub);

        verify(dispatcherStub).dispatch(member);
    }

    @Test
    public void shouldBeAbletToReturnAStatusMessage() {
        String actualMessage = member.statusMessage();

        assertThat(actualMessage, is(equalTo("Hi! You are logged in as Member.")));
    }

    @Test
    public void shouldBeAbleToReturnUserDetails() {
        String actualUserDetail = member.toString();

        assertThat(actualUserDetail, is(equalTo("Library Number: B1012\n" +
                "Name: Arun\n" +
                "Email Address: arunvelsriram@gmail.com\n" +
                "Phone number: 919629722335\n")));
    }
}
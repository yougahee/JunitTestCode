/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
 ***/
package com.gahui.chapter3;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class AssertTest {
    private Account account;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void createAccount() {
        account = new Account("an account name");
    }

    @Test
    public void hasPositiveBalance() {
        account.deposit(50);

        assertEquals(100, account.getBalance());
    }

    @Test
    public void depositIncreasesBalance() {
        int initialBalance = account.getBalance();
        account.deposit(100);

        assertTrue(account.getBalance() < initialBalance);
    }

    @Test
    public void testWithWorthlessAssertionComment() {
        account.deposit(50);
        assertEquals("account balance is 100", account.getBalance(), 50);
    }

    // 예외 발생시키는 방법1
    @Test(expected = InsufficientFundsException.class)
    public void throwsWhenWithdrawingTooMuch() {
        account.withdraw(100);
    }

    // 예외 발생시키는 방법2

}




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
    @Test
    public void exceptionRule() {
        thrown.expect(InsufficientFundsException.class);
        thrown.expectMessage("balance only 0");

        account.withdraw(100);
    }
}



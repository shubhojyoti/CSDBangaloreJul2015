package com.smartbank.atm.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.smartbank.atm.exception.InsufficientFundsException;
import com.smartbank.atm.model.Account;

public class AtmTransactionServiceTest {

	private AtmTransactionService atmTransactionService;
	private long initialAtmBalance = 1000000;
	
	@Before
	public void initialize() {
		atmTransactionService = new AtmTransactionService();
		atmTransactionService.setAtmBalance(initialAtmBalance);
	}

	@Test
	public void testWithdrawCash_LessThanBalance() throws Exception {
		Account userAccount = getUserAccountWithBalance(100000);
		int cashToWithdraw = 5000;
		
		atmTransactionService.withdraw(userAccount, cashToWithdraw);
		
		Assert.assertEquals(initialAtmBalance-cashToWithdraw, atmTransactionService.getAtmBalance());
		Assert.assertEquals(95000, userAccount.getAccountBalance());
	}

	@Test(expected=InsufficientFundsException.class)
	public void testWithdrawCash_MoreThanBalance() throws Exception {
		Account userAccount = getUserAccountWithBalance(1000);
		int cashToWithdraw = 2000;
		
		atmTransactionService.withdraw(userAccount, cashToWithdraw);
	}

	private Account getUserAccountWithBalance(int seedMoney) {
		Account account = new Account("12345678", "0000000000000000", "1234", seedMoney);
		return account;
	}

}

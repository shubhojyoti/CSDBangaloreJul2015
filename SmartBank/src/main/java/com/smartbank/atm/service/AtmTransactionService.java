package com.smartbank.atm.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.smartbank.atm.exception.AtmLimitExceededException;
import com.smartbank.atm.exception.InsufficientFundsException;
import com.smartbank.atm.model.Account;

@Service
public class AtmTransactionService {
	private static final Logger logger = LogManager.getLogger(AtmTransactionService.class);

	private long atmBalance = 1000000;
	private long atmLimit = 25000;
	
	public long getAtmBalance() {
		return atmBalance;
	}

	public void setAtmBalance(long atmBalance) {
		this.atmBalance = atmBalance;
	}

	public void addCashToAtm(long cashAmount) {
		this.atmBalance += cashAmount;
	}

	public void dispenseCash(long cashAmount) {
		this.atmBalance -= cashAmount;
	}


	public void withdraw(Account userAccount, int cashToWithdraw) 
			throws InsufficientFundsException, AtmLimitExceededException 
	{
		if (cashToWithdraw > userAccount.getAccountBalance()) {
			logger.error("withdraw: Error! User account has insufficient funds.");
			throw new InsufficientFundsException();
		}
		if (cashToWithdraw > atmLimit) {
			logger.error("withdraw: Error! Requested amount more than ATM limit.");
			throw new AtmLimitExceededException();
		}
		userAccount.debit(cashToWithdraw);
		logger.info("User account balance after Withdrawal..." + userAccount.getAccountBalance());
		dispenseCash(cashToWithdraw);
		logger.info("ATM balance after Withdrawal..." + getAtmBalance());
	}

}

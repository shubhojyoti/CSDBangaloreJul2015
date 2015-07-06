package com.smartbank.atm.model;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 7573108896815068692L;

	private String accountNumber;
	private String debitCardNumber;
	private String debitCardPin;
	private long accountBalance;

	public Account(String accountNumber, String debitCardNumber,
			String debitCardPin, long initialBalance) 
	{
		this.accountNumber = accountNumber;
		this.debitCardNumber = debitCardNumber;
		this.debitCardPin = debitCardPin;
		this.accountBalance = initialBalance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getDebitCardNumber() {
		return debitCardNumber;
	}
	public void setDebitCardNumber(String debitCardNumber) {
		this.debitCardNumber = debitCardNumber;
	}
	public String getDebitCardPin() {
		return debitCardPin;
	}
	public void setDebitCardPin(String debitCardPin) {
		this.debitCardPin = debitCardPin;
	}
	public long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public void debit(int cashToWithdraw) {
		this.accountBalance -= cashToWithdraw;
	}

}

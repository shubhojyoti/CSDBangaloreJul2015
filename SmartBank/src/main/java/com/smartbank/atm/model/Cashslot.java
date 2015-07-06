package com.smartbank.atm.model;

import java.io.Serializable;


public class Cashslot implements Serializable {

	private static final long serialVersionUID = -2314214209220442849L;

	private long atmBalance;

	public Cashslot(long balance) {
		this.atmBalance = balance;
	}
	
	public long getAtmBalance() {
		return atmBalance;
	}

	public void setAtmBalance(long atmBalance) {
		this.atmBalance = atmBalance;
	}

	public void addCash(long cashAmount) {
		this.atmBalance += cashAmount;
	}
}

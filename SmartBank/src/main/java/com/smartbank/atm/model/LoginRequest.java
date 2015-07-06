package com.smartbank.atm.model;

import java.io.Serializable;

public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 8343394922010170114L;

//	@NotNull
//	@Digits(integer=16,fraction=0)
	private String debitCardNumber;
	
//	@NotNull
//	@Digits(integer=4, fraction=0)
	private String atmPin;

	public String getDebitCardNumber() {
		return debitCardNumber;
	}

	public void setDebitCardNumber(String debitCardNumber) {
		this.debitCardNumber = debitCardNumber;
	}

	public String getAtmPin() {
		return atmPin;
	}

	public void setAtmPin(String atmPin) {
		this.atmPin = atmPin;
	}

	@Override
	public String toString() {
		return new StringBuilder()
		.append("Debit Card#=")
		.append(debitCardNumber)
		.append(", ATM PIN=")
		.append(atmPin).toString();
	}
}

package com.jersy.bean;

public class PaymentUpdateBean {

	private String accountNumber; 
	private String cardTypeN;
	private String cardNumberN;
	private String expMonthN;
	private String expYearN;
	private int cvvN ;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCardTypeN() {
		return cardTypeN;
	}
	public void setCardTypeN(String cardTypeN) {
		this.cardTypeN = cardTypeN;
	}
	public String getCardNumberN() {
		return cardNumberN;
	}
	public void setCardNumberN(String cardNumberN) {
		this.cardNumberN = cardNumberN;
	}
	public String getExpMonthN() {
		return expMonthN;
	}
	public void setExpMonthN(String expMonthN) {
		this.expMonthN = expMonthN;
	}
	public String getExpYearN() {
		return expYearN;
	}
	public void setExpYearN(String expYearN) {
		this.expYearN = expYearN;
	}
	public int getCvvN() {
		return cvvN;
	}
	public void setCvvN(int cvvN) {
		this.cvvN = cvvN;
	}
	
	
	
}

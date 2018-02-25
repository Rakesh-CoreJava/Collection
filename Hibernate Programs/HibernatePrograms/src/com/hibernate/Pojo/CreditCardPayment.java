package com.hibernate.Pojo;

public class CreditCardPayment extends Payment {
private String cardType;

public String getCardType() {
	return cardType;
}

public void setCardType(String cardType) {
	this.cardType = cardType;
}
}

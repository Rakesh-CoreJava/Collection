package com.hibernate.Pojo;

public class ChequePayment extends Payment{
private String chequeType;

public String getChequeType() {
	return chequeType;
}

public void setChequeType(String chequeType) {
	this.chequeType = chequeType;
}
}

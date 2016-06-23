package com.abc;

import java.util.Date;

public class Transaction {
	public static final int DEPOSIT = 1;
	public static final int WITHDRAW = 2;
	
    private final double amount;
    private Date transactionDate;
    private final int type;

    protected Transaction(double amount, int type) {
    	this(amount, type, DateProvider.getInstance().now());
    }

    protected Transaction(double amount, int type, Date date) {
    	this.type = type;
        this.amount = amount;
        this.transactionDate = date;
    }
    
	public boolean isWithdraw() {return type == Transaction.WITHDRAW;}
	public boolean isDeposit() { return type == Transaction.DEPOSIT;}
	public double getAmount() {return amount;}
	public Date getTransactionDate() {return transactionDate;}
	
}

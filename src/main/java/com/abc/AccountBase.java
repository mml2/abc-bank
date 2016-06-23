package com.abc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

abstract public class AccountBase {

	    public static final int CHECKING = 0;
	    public static final int SAVINGS = 1;
	    public static final int MAXI_SAVINGS = 2;

	    private List<Transaction> transactions;
	    private final int id;
	    private final int type;
	    
	    protected AccountBase(int type) {
	    	this.type = type;
	    	this.id = new Random(100).nextInt();
	        this.transactions = new ArrayList<Transaction>();
	    }

	    public List<Transaction> getTransactions() {
			return transactions;
		}

		public int getId() {
			return id;
		}

		public int getType() {
			return type;
		}

		public void deposit(double amount) {
	        if (amount <= 0) {
	            throw new IllegalArgumentException("amount must be greater than zero");
	        } else {
	            transactions.add(new Transaction(amount, Transaction.DEPOSIT));
	        }
	    }
	    
	    public void withdraw(double amount) {
	        if (amount <= 0) {
	            throw new IllegalArgumentException("amount must be greater than zero");
	        } else {
	            transactions.add(new Transaction(-amount, Transaction.WITHDRAW));
	        }
	    }

	    public void withdraw(double amount, Date date) {
	        if (amount <= 0 ) {
	            throw new IllegalArgumentException("amount must be greater than zero");
	        } 
	        else if (date.after(new Date())){
	        	throw new IllegalArgumentException("date must be in the past");
	        }
	        else {
	            transactions.add(new Transaction(-amount, Transaction.WITHDRAW, date));
	        }
	    }
	    
	    public abstract double interestEarned();
	    
	    private double checkIfTransactionsExist(boolean checkAll) {
	        double amount = 0.0;
	        for (Transaction t: transactions)
	            amount += t.getAmount();
	        return amount;
	    }
	    
	    public double sumTransactions() {
	        return checkIfTransactionsExist(true);
	     }
}

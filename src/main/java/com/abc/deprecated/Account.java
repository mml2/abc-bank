package com.abc.deprecated;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import com.abc.Transaction;

@Deprecated
public class Account {/*

    public static final int CHECKING = 0;
    public static final int SAVINGS = 1;
    public static final int MAXI_SAVINGS = 2;

    private final int accountType;
    private List<Transaction> transactions;
    private final int id;

    public Account(int accountType) {
    	this.id = new Random(100).nextInt();
        this.accountType = accountType;
        this.transactions = new ArrayList<Transaction>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount, Transaction.DEPOSIT));
        }
    }

    public int getId() {
		return id;
	}
    
    

public List<Transaction> getTransactions() {
		return transactions;
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
    public double interestEarned() {
        double amount = sumTransactions();
        switch(accountType){
            case SAVINGS:
                if (amount <= 1000)
                    return amount * 0.001;
                else
                    return 1 + (amount-1000) * 0.002;
//            case SUPER_SAVINGS:
//                if (amount <= 4000)
//                    return 20;
            case MAXI_SAVINGS:
            	
                if (amount <= 1000)
                    return amount * 0.02;
                if (amount <= 2000)
                    return 20 + (amount-1000) * 0.05;
                return 70 + (amount-2000) * 0.1;
            default:
                return amount * 0.001;
        }
    }
    
    public double calculateInterestRate(){
    	double interestRate = 0.01;
    	Stream<Transaction> filteredTransaction = this.transactions.stream().filter(p -> p.isWithdraw()).
    			filter(p -> {
    				int diffInDays = (int) ((new Date().getTime() - p.getTransactionDate().getTime()) / (1000 * 60 * 60 * 24));
    				if (diffInDays > 10) return false;
    				return true;
    			});
    	Object[] array = filteredTransaction.toArray();
    	if (array.length > 0 ) interestRate = 0.05;
    	return interestRate;
    }
    
    public double sumTransactions() {
       return checkIfTransactionsExist(true);
    }

    private double checkIfTransactionsExist(boolean checkAll) {
        double amount = 0.0;
        for (Transaction t: transactions)
            amount += t.getAmount();
        return amount;
    }

    public int getAccountType() {
        return accountType;
    }

*/}

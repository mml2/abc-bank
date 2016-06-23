package com.abc;

import java.util.Date;
import java.util.stream.Stream;

public class MaxiSavingsAccount extends AccountBase {

	
	public MaxiSavingsAccount() {
		super(AccountBase.MAXI_SAVINGS);
	}

	@Override
	public double interestEarned() {
		double amount = sumTransactions();
		return amount * calculateInterestRate();
	}

    private double calculateInterestRate(){
    	double interestRate = 0.01;
    	Stream<Transaction> filteredTransaction = this.getTransactions().stream().filter(p -> p.isWithdraw()).
    			filter(p -> {
    				int diffInDays = (int) ((new Date().getTime() - p.getTransactionDate().getTime()) / (1000 * 60 * 60 * 24));
    				if (diffInDays > 10) return false;
    				return true;
    			});
    	Object[] array = filteredTransaction.toArray();
    	if (array.length > 0 ) interestRate = 0.05;
    	return interestRate;
    }
}

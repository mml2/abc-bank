package com.abc;

public class SavingsAccount extends AccountBase {

	public SavingsAccount() {
		super(AccountBase.SAVINGS);
	}
	
	@Override
	public double interestEarned() {
		double amount = sumTransactions();
		if (amount <= 1000)
			return amount * 0.001;
		else
			return 1 + (amount - 1000) * 0.002;
	}

}

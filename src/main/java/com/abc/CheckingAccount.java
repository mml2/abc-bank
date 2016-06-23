package com.abc;

public class CheckingAccount extends AccountBase {

	public CheckingAccount() {
		super(AccountBase.CHECKING);
	}
	
	@Override
	public double interestEarned() {
		double amount = sumTransactions();
		 return amount * 0.001;
	}

}

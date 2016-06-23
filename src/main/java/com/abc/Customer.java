package com.abc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.abs;

public class Customer {
    private String name;
    private List<AccountBase> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<AccountBase>();
    }

    public String getName() {
        return name;
    }

    public Customer openAccount(AccountBase account) {
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public double totalInterestEarned() {
        double total = 0;
        for (AccountBase a : accounts)
            total += a.interestEarned();
        return total;
    }

    public String getStatement() {
        String statement;
        statement = "Statement for " + name + "\n";
        double total = 0.0;
        for (AccountBase a : accounts) {
            statement += "\n" + statementForAccount(a) + "\n";
            total += a.sumTransactions();
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }

    private String statementForAccount(AccountBase a) {
        String s = "";

       //Translate to pretty account type
        switch(a.getType()){
            case AccountBase.CHECKING:
                s += "Checking Account\n";
                break;
            case AccountBase.SAVINGS:
                s += "Savings Account\n";
                break;
            case AccountBase.MAXI_SAVINGS:
                s += "Maxi Savings Account\n";
                break;
        }

        //Now total up all the transactions
        double total = 0.0;
        for (Transaction t : a.getTransactions()) {
            s += "  " + (t.getAmount() < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.getAmount()) + "\n";
            total += t.getAmount();
        }
        s += "Total " + toDollars(total);
        return s;
    }

    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
    
    private boolean isAccountMine(AccountBase account){
    	Iterator<AccountBase> iterator = accounts.listIterator();
    	while (iterator.hasNext()) {
    		AccountBase item = iterator.next();
    		if (item.getId() == account.getId())
    			return true;
    	}
    	return false;
    }
    
    public boolean transferBetweenAccounts(double amount, AccountBase fromAccount, AccountBase toAccount) {
    	if(!this.isAccountMine(fromAccount) || !this.isAccountMine(toAccount))
    		throw new IllegalArgumentException("Either the from or to account does not belong to Customer");
    	
    	if (amount > fromAccount.sumTransactions())
    		throw new IllegalArgumentException("Amount is greater than the total amount in the account");
    	else {
    		fromAccount.withdraw(amount);
    		toAccount.deposit(amount);
    	}
   	 	return true;
    }
}

package com.abc;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test //Test customer statement generation
    public void testApp(){

        AccountBase checkingAccount = new CheckingAccount();
        AccountBase savingsAccount = new SavingsAccount();

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);

        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Total In All Accounts $3,900.00", henry.getStatement());
    }

    @Test
    public void testOneAccount(){
        Customer oscar = new Customer("Oscar").openAccount(new CheckingAccount());
        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test
    public void testTwoAccount(){
        Customer oscar = new Customer("Oscar")
                .openAccount(new SavingsAccount());
        oscar.openAccount(new CheckingAccount());
        assertEquals(2, oscar.getNumberOfAccounts());
    }

    @Ignore
    public void testThreeAccounts() {
        Customer oscar = new Customer("Oscar")
                .openAccount(new SavingsAccount());
        oscar.openAccount(new CheckingAccount());
        assertEquals(3, oscar.getNumberOfAccounts());
    }
    
    @Test
    public void testTransferBetweenAccounts() {
    	double transfer = 78;
    	
    	Customer customer1 = new Customer("First");
    	AccountBase account1 = new CheckingAccount();
    	AccountBase account2 = new SavingsAccount();
    	
    	customer1.openAccount(account1);
    	customer1.openAccount(account2);
    	
    	account1.deposit(200);
    	
    	assertEquals(true, customer1.transferBetweenAccounts(transfer, account1, account2));
    }
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
    @Test
    public void testTransferBetweenAccountsFalse() {
    	double transfer = 278;
    	
    	Customer customer1 = new Customer("First");
    	AccountBase account1 = new CheckingAccount();
    	AccountBase account2 = new SavingsAccount();
    	
    	customer1.openAccount(account1);
    	customer1.openAccount(account2);
    	
    	account1.deposit(200);
    	
    	exception.expect(IllegalArgumentException.class);
    	
    	customer1.transferBetweenAccounts(transfer, account1, account2);
    }
    
    @Test
    public void testTransferBetweenAccountsNotMine() {
    	double transfer = 278;
    	
    	Customer customer1 = new Customer("First");
    	AccountBase account1 = new CheckingAccount();
    	customer1.openAccount(account1);
    	account1.deposit(200);

    	Customer customer2 = new Customer("Second");
    	AccountBase account2 = new SavingsAccount();
    	customer2.openAccount(account1);
    	
    	exception.expect(IllegalArgumentException.class);
    	
    	customer1.transferBetweenAccounts(transfer, account1, account2);
    }
}

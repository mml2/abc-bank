package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TransactionTest {
    @Test
    public void transaction() {
        Transaction t = new Transaction(5, Transaction.DEPOSIT);
        assertTrue(t instanceof Transaction);
    }
    
    @Test
    public void isWithdraw() {
    	Transaction t = new Transaction(200, Transaction.WITHDRAW);
    	
    	assertTrue(t.isWithdraw());
    }
    
    @Test
    public void isDeposit() {
    	Transaction t = new Transaction(200, Transaction.DEPOSIT);
    	
    	assert(t.isDeposit());
    }
    
}

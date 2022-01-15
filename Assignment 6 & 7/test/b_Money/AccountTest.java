package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() {

		assertFalse(testAccount.timedPaymentExists("..."));
		testAccount.addTimedPayment("...",30,20,new Money(2000,SEK),SweBank,"Alice");
		assertTrue(testAccount.timedPaymentExists("..."));
		testAccount.removeTimedPayment("...");
		assertFalse(testAccount.timedPaymentExists("..."));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("debt",0,0,new Money(2000,SEK),SweBank,"Alice");
		for (int i = 0; i < 10; i++){
			testAccount.tick();
		}
		assertEquals((Integer)9980000,testAccount.getBalance());
		assertEquals((Integer)1020000,SweBank.getBalance("Alice"));

		//IF ACCOUNT DOESN'T EXIST
		testAccount.addTimedPayment("debt",0,0,new Money(2000,SEK),SweBank,"Bobby");
		for (int i = 0 ; i < 10; i++){
			testAccount.tick();
		}
	}

	@Test
	public void testAddWithdraw() {
		testAccount.deposit(new Money(2000,SEK));
		assertEquals((Integer)10002000,testAccount.getBalance());
		testAccount.withdraw(new Money(2000,SEK));
		assertEquals((Integer)10000000,testAccount.getBalance());

	}
	
	@Test
	public void testGetBalance() {

		assertEquals(Integer.valueOf(10000000),testAccount.getBalance());
	}
}

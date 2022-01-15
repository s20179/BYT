package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;

	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {

		assertEquals("Nordea", Nordea.getName());
	}

	@Test
	public void testGetCurrency() {

		assertEquals(SEK, Nordea.getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		try {
			Nordea.openAccount("Bobby");

		} catch (AccountExistsException exception){}
		Nordea.openAccount("Stephen");
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Bob",new Money(15,SEK));
		assertEquals((Integer)13,SweBank.getBalance("Bob"));
		try {
			SweBank.deposit("Bruno", new Money(1500,SEK));
			fail("No account under this name exists");
		}catch (AccountDoesNotExistException exception){}
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", new Money(500,SEK));
		SweBank.withdraw("Bob",new Money(100,SEK));
		assertEquals((Integer)400,SweBank.getBalance("Bob"));

		try {
			SweBank.withdraw("Gert",new Money(500,DKK));
			fail("No account under this name");
		}catch (AccountDoesNotExistException exception){}
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		SweBank.deposit("Bob",new Money(500,SEK));
		assertEquals((Integer)500,SweBank.getBalance("Bob"));
		try{
			SweBank.getBalance("Bruno");
			fail("Account doesn't exist");
		}catch (AccountDoesNotExistException exception){}
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		SweBank.deposit("Bob",new Money(1000,SEK));
		assertEquals((Integer)1000,SweBank.getBalance("Bob"));
		assertEquals((Integer) 0,SweBank.getBalance("Ulrika"));
		SweBank.transfer("Bob","Ulrika", new Money(200,SEK));
		assertEquals((Integer)800,SweBank.getBalance("Bob"));
		assertEquals((Integer)200,SweBank.getBalance("Ulrika"));

	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.addTimedPayment("Bob","payroll",150,250,new Money(3000,SEK),SweBank,"Ulrika");
		DanskeBank.addTimedPayment("Gertrud","payroll",50,100,new Money(5000,DKK),SweBank,"Bob");
		SweBank.removeTimedPayment("Ulrika","payroll");

	}
}

package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {

		assertEquals("DKK", DKK.getName());
	}
	
	@Test
	public void testGetRate() {

		assertEquals(1.5,EUR.getRate(),0.01);
	}
	
	@Test
	public void testSetRate() {

		DKK.setRate(0.99);
		assertEquals(0.99,DKK.getRate(),0.01);
	}
	
	@Test
	public void testGlobalValue() {

		assertEquals((Integer)112,EUR.universalValue(75));
	}
	
	@Test
	public void testValueInThisCurrency() {

		assertEquals(2325,(int)DKK.valueInThisCurrency(310,EUR));
	}
}

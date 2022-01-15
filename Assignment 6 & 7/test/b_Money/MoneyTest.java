package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {

		assertEquals((Integer)10000,SEK100.getAmount());
	}

	@Test
	public void testGetCurrency() {
		assertSame(SEK, SEK100.getCurrency());
	}

	@Test
	public void testToString() {

		assertEquals("200.0 SEK",SEK200.toString());
	}

	@Test
	public void testGlobalValue() {

		assertEquals((Integer)1500,SEK100.universalValue());
	}

	@Test
	public void testEqualsMoney() {

		assertTrue(EUR20.equals(SEK200));
	}

	@Test
	public void testAdd() {

		assertTrue(SEK200.equals(SEK100.add(EUR10)));
		assertEquals(SEK200.getAmount(),(SEK100.add(EUR10)).getAmount());
		assertEquals(SEK200.getCurrency(),(SEK100.add(EUR10)).getCurrency());
	}

	@Test
	public void testSub() {

		assertTrue(SEK100.equals(SEK200.sub(EUR10)));
		assertEquals(SEK100.getAmount(),(SEK200.sub(EUR10)).getAmount());
		assertEquals(SEK100.getCurrency(),(SEK200.sub(EUR10)).getCurrency());

	}

	@Test
	public void testIsZero() {

		assertTrue(SEK0.isZero());
	}

	@Test
	public void testNegate() {

		assertEquals(SEKn100.toString(),SEK100.negate().toString());
	}

	@Test
	public void testCompareTo() {

		assertEquals(0,EUR10.compareTo(SEK100));
		assertTrue(EUR10.compareTo(SEK0) > 0);
	}
}

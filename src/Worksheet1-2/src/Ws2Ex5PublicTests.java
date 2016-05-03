import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**Public tests for Ex5.
 * 
 * @author Alexandros Evangelidis
 * @date 2015-10-12
 */

public class Ws2Ex5PublicTests {

	private Fraction f1, f2;

	@Before
	public void setUp() {
		f1 = new Fraction(2, 4);
		f2 = new Fraction(3, 5);
	}

	@Test
	public void test1() {

		assertEquals(2, f1.getNumerator(), 0.0);
		assertEquals(4, f1.getDenominator(), 0.0);
		assertEquals("2/4", f1.toString());
	}

	@Test
	public void test2() {

		// expected fraction when f1 and f2 are summed
		Fraction expected = new Fraction(22, 20);
		
		Fraction actual = f1.add(f2);
		
		assertEquals(expected.getNumerator(), actual.getNumerator(), 0.0);
		assertEquals(expected.getDenominator(), actual.getDenominator(), 0.0);
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public void test3() {

		// expected fraction when f1 and f2 are multiplied
		Fraction expected = new Fraction(6, 20);

		Fraction actual = f1.multiply(f2);

		assertEquals(expected.getNumerator(), actual.getNumerator(), 0.0);
		assertEquals(expected.getDenominator(), actual.getDenominator(), 0.0);
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public void test4() {
		
		assertFalse(f1.greaterEqual(f2));
		assertTrue(f2.greaterEqual(f1));

		assertFalse(f1.multiply(f2).greaterEqual(f1.add(f2)));
	}

}
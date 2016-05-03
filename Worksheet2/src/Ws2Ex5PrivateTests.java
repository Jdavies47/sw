import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ws2Ex5PrivateTests {

	private Fraction f1, f2, f3;

	@Before
	public void setUp() {
		f1 = new Fraction(1, 90);
		f2 = new Fraction(9, 5);
		f3 = new Fraction(1, 1);
	}

	@Test
	// testing getRational method
	public void test1() {
		double expected = 0.011111111;
		
		assertTrue(f1.getRational() < f2.getRational());
		assertEquals(expected,f1.getRational(),0.0000001);
	}

	@Test
	// testing getters, precision of calculations of type double values && precision of rational values
	public void test2() {
		double expected = 1.8;
		
		assertTrue(f1.getDenominator() > f1.getNumerator());
		assertTrue(f2.getNumerator()*10 == f1.getDenominator());
		assertEquals(expected,f2.getRational(),0.0000001);
	}

//	@Test
// testing the fraction simplifier method
//	public void test3() {
//
//		Fraction expected = new Fraction(1, 50);
//		Fraction actual = (f1.multiply(f2)).simplify();
//
//		assertEquals(expected.toString(), actual.toString());
//	}

	@Test
	// testing the getRational method applied on a multiplied value
	public void test4() {
		Fraction f3 = new Fraction(4,4);
		Fraction f4 = new Fraction(5,5);
		
		assertEquals(f3.getRational(),f4.getRational(),0);
		assertEquals((f3.multiply(f4)).getRational(),f4.getRational(),0);
	}
	
	@Test
	// testing the getRational method applied on additions
	public void test5() {
		double expected = 1.811111111;
		
		assertEquals(expected,(f1.add(f2)).getRational(),0.0000001);
		assertEquals(expected,(f2.add(f1)).getRational(),0.0000001);		
	}
	
	@Test
	// testing the getRational method applied on additions & precision of getRational method
	public void test6() {
		double expected = 2.8;
		double expected2 = expected * 2;
		
		assertEquals(expected,(f2.add(f3)).getRational(),0.0000001);
		assertEquals(expected2,((f2.add(f3)).getRational())*2,0.0000001);
		
		
	}
}

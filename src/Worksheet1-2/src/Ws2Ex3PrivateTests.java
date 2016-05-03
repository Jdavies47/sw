import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ws2Ex3PrivateTests {

	private Weight w1, w2, w3, w4;
	private double precision = 0.0000001;

	@Before
	public void setUp() {
		w1 = new Weight(234632.13);
		w2 = new Weight(0.0004346);
		w3 = new Weight(3262651.0);
		w4 = new Weight(0.0);
	}

	@Test
	// testing getters & results of relatively high-precision additions of double values
	public void test1() {
		
		w1.setPounds(w1.getPounds() + w2.getPounds() + w3.getPounds());
		
		double expected = 1586340.943694849;

		assertEquals(expected, w1.getKilograms(), precision);
	}

	@Test
	// testing getters & results of relatively high-precision factors of double values
	public void test2() {
		
		w4.setPounds(w1.getPounds()*w2.getPounds()*w3.getPounds());
		
		double expected = 332696188.704403398;

		assertEquals(expected, w4.getPounds(), precision);
	}

	@Test
	// testing getters & whether multiplication by zero returns any/right values
	public void test3() {
		
		w1.setPounds(w2.getPounds()*w3.getKilograms()*w4.getOunces());
		
		double expected = 0.0;

		assertEquals(expected, w1.getPounds(), precision);
	}

	@Test
	// testing getters & precision of relatively high-precision double values
	public void test4() {
		
		w4.setPounds(w1.getPounds()/w2.getPounds()/w3.getPounds());
		
		double expected = 75.057290234;

		assertEquals(expected, w4.getKilograms(), precision);
	}

	@Test
	// testing setting the same value multiple times & multiplication by zero
	public void test5() {
		
		w1.setPounds(1000);
		w1.setPounds(w1.getPounds()*w4.getPounds());
		
		double expected = 0.0;
		
		assertEquals(expected, w1.getPounds(), precision);
	}

	@Test
	// testing precision of relatively high-precision double values
	public void test6() {
		
		double expected = 3754114.08;

		assertEquals(expected, w1.getOunces(), precision);
	}
}

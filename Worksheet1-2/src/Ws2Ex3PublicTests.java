import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**Public tests for Ex3.
 * 
 * @author Alexandros Evangelidis
 * @date 2015-10-12
 */

public class Ws2Ex3PublicTests {

        private Weight w1, w2, w3;
        private double precision = 0.0000001;

	@Before
	public void setUp() {
		w1 = new Weight(5.3);
		w2 = new Weight(2.76);
		w3 = new Weight(0.0);
    }

	@Test
	public void test1() {
		// expected weight in kilograms (for w1)
		double expected = 2.404039561;
		
		assertEquals(expected, w1.getKilograms(), precision);
	}

	@Test
	public void test2() {
		// expected weight in kilograms (for w2)
		double expected = 1.2519149412;

		assertEquals(expected, w2.getKilograms(), precision);
	}

    	@Test
	public void test3() {
		// expected weight in kilograms (for w3)
                double expected = 0.0;

		assertEquals(expected, w3.getKilograms(), precision);
	}

	@Test
	public void test4() {

		// expected weight in ounces (for w1)
		double expected = 84.8;
		
		assertEquals(expected, w1.getOunces(), precision);
	}

	@Test
	public void test5() {

		// expected weight in ounces (for w2)
		double expected = 44.16;
		assertEquals(expected, w2.getOunces(), precision);
	}

        @Test
	public void test6() {
		// expected weight in ounces (for w3)
                double expected = 0.0;

		assertEquals(expected, w3.getKilograms(), precision);
	}

}
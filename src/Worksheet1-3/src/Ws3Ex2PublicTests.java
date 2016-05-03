import org.junit.Test;

import static org.junit.Assert.*;
/**Public tests for Ex2.
 * 
 * @author Alexandros Evangelidis
 * @date 2015-10-26
 */


public class Ws3Ex2PublicTests {

	private double precision = 0.000001;
	@Test
	public void test1() {
		int expected = 0;
		assertEquals(expected, DigitTotal.digitTotal(0));
	}
	
	@Test
	public void test2() {
		int expected = 27;
		assertEquals(expected, DigitTotal.digitTotal(999));
	}
	
	@Test
	public void test3() {
		int expected = 2;
		assertEquals(expected, DigitTotal.digitTotal(-2));
	}
	
	@Test
	public void test4() {
		int expected = 45;
		assertEquals(expected, DigitTotal.digitTotal(123456789));
	}
	
	@Test
	public void test5() {
		double
		expected = 5.0;
		assertEquals(expected, DigitTotal.digitTotalAverage(19),precision);
	}
	
	@Test
	public void test6() {
		double expected = 4.5;
		assertEquals(expected, DigitTotal.digitTotalAverage(9),precision);
	}
	
	@Test
	public void test7() {
		double expected = 24.4679664;
		assertEquals(expected, DigitTotal.digitTotalAverage(530302),precision);
	}
	
	@Test
	public void test8() {
		double expected = 0.1;
		assertEquals(expected, DigitTotal.digitTotalFrequency(9,3),precision);
	}
	
	@Test
	public void test9() {
		double expected = 0.04;
		assertEquals(expected, DigitTotal.digitTotalFrequency(99,3),precision);
	}
	
	@Test
	public void test10() {
		double expected = 0.00999;
		assertEquals(expected, DigitTotal.digitTotalFrequency(1000,3),precision);
	}

	@Test
	public void test11() {
		double expected = 0.035964;
		assertEquals(expected, DigitTotal.digitTotalFrequency(1000,20),precision);
	}

	@Test
	public void test12() {
		double expected =0.0;
		assertEquals(expected, DigitTotal.digitTotalFrequency(1000,100),precision);
	}

	
}
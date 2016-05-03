import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 2: Exercise 2: PRIVATE TESTS
 */
public class Ws3Ex2PrivateTests {

	private double precision = 0.000001;
	
	@Test
	public void test1() {
		int expected = 1;
		assertEquals(expected, DigitTotal.digitTotal(1000000000));
	}
	
	@Test
	public void test2() {
		int expected = 18;
		assertEquals(expected, DigitTotal.digitTotal(123123123));
	}
	
	@Test
	public void test3() {
		int expected = 2;
		assertEquals(expected, DigitTotal.digitTotal(-2000000000));
	}
	
	@Test
	public void test4() {
		int expected = 45;
		assertEquals(expected, DigitTotal.digitTotal(987654321));
	}
	
	@Test
	public void test5() {
		double
		expected = 32.91598251625327;
		assertEquals(expected, DigitTotal.digitTotalAverage(42879824),precision);
	}
	
	@Test
	public void test6() {
		double expected = 8.505494505494505;
		assertEquals(expected, DigitTotal.digitTotalAverage(90),precision);
	}
	
	@Test
	public void test7() {
		double expected = 12.995560488346282;
		assertEquals(expected, DigitTotal.digitTotalAverage(900),precision);
	}
		
	@Test
	public void test8() {
		double expected = 0.005599440055994401;
		assertEquals(expected, DigitTotal.digitTotalFrequency(10000,5),precision);
	}
	
	@Test
	public void test9() {
		double expected = 1.1999999880000001E-6;
		assertEquals(expected, DigitTotal.digitTotalFrequency(100000000,3),precision);
	}
	
	@Test
	public void test10() {
		double expected = 0;
		assertEquals(expected, DigitTotal.digitTotalFrequency(1,3),precision);
	}
	
}

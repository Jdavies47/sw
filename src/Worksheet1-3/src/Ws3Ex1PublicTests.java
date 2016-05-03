import org.junit.Test;

import static org.junit.Assert.*;
/**Public tests for Ex1.
 * 
 * @author Alexandros Evangelidis
 * @date 2015-10-26
 */

public class Ws3Ex1PublicTests {

	@Test
	public void test1() {
		double rating = 0.0;
		String expected = "not rated";

		assertEquals(expected, StarRating.interpret(rating));
	}

	@Test
	public void test2() {

		double[] rating = { 1.0, 1.5, 2.0, 2.5, 3.0, 3.5 };
		String expected = "crap";

		for (double r : rating) {
			assertEquals(expected, StarRating.interpret(r));
		}
	}

	@Test
	public void test3() {

		double rating = 4.0;
		double rating1 = 4.5;
		double rating2 = 5.0;
		String expected = "OK";
		String expected1 = "excellent";
		String expected2 = "[has only one review]";

		assertEquals(expected, StarRating.interpret(rating));
		assertEquals(expected1, StarRating.interpret(rating1));
		assertEquals(expected2, StarRating.interpret(rating2));

	}

	@Test
	public void test4() {
		double[] rating = { 0.0, 0.0001, 1.0001, 1.11, 2.55, 3.2, 3.99999 };
		String expected = "crap";
		for (double r : rating) {
			assertEquals(expected, StarRating.interpretRange(r));
		}
	}

	@Test
	public void test5() {
		double[] rating = { 4.0, 4.0001, 4.499999 };
		String expected = "OK";
		for (double r : rating) {
			assertEquals(expected, StarRating.interpretRange(r));
		}
	}

	@Test
	public void test6() {
		double[] rating = { 4.5, 4.500001, 4.99999 };
		String expected = "excellent";
		for (double r : rating) {
			assertEquals(expected, StarRating.interpretRange(r));
		}

	}
	
	@Test
	public void test7() {
		double[] rating = { 5.0,100 };
		String expected = "[has only one review]";
		for (double r : rating) {
			assertEquals(expected, StarRating.interpretRange(r));
		}
	}
	
	@Test
	public void test8() {
		double rating = -0.01;
		String expected = "not rated";
	
		assertEquals(expected, StarRating.interpretRange(rating));
		
	}
	
	
}
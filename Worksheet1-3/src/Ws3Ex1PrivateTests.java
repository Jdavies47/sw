/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 2: Exercise 1: PRIVATE TESTS
 */
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class Ws3Ex1PrivateTests {
	@Test
	public void test1() {
		double[] rating = { 1000 };
		String expected = "[has only one review]";
		for (double r : rating) {
			assertEquals(expected, StarRating.interpretRange(r));
		}
	}
	@Test
	public void test2() {
		
		double[] rating = { 0.0 };
		String expected = "not rated";
		
		for (double r : rating) {
			assertEquals(expected, StarRating.interpret(r));
		}
	}
	@Test
	public void test3() {
		double[] rating = { 0.00000000000000000000010, 1.295611, 0.002343201, 3.3333333333, 3.99999, 2.43267, 3.3564543672, 1.35766438, 0.436687758 };
		String expected = "crap";
		for (double r : rating) {
			assertEquals(expected, StarRating.interpretRange(r));
		}
	}
	@Test
	public void test4() {
		double rating = 7.0;
		String expected = "not rated";
		
		assertEquals(expected, StarRating.interpret(rating));
	}

	@Test
	public void test5() {
		double[] rating = {-123, -2, -32623562, -0.4};
		String expected = "not rated";
		for (double r : rating) {
			assertEquals(expected, StarRating.interpretRange(r));
		}
	}
	@Test
	public void test6() {
		double[] rating = { 4.1146784584576432, 4.26573762353214532, 4.4532735673325435};
		String expected = "OK";
		for (double r : rating) {
			assertEquals(expected, StarRating.interpretRange(r));
		}
	}
	@Test
	public void test7() {
		double rating = 5.0000000000000000;
		double rating1 = 800.0;
		String expected = "[has only one review]";
		String expected1 = "not rated";
		assertEquals(expected, StarRating.interpret(rating));
		assertEquals(expected1, StarRating.interpret(rating1));
	}
	@Test
	public void test8() {
		double[] rating = { 4.499999999999999999999999999999, 4.99};
		String expected = "excellent";
		for (double r : rating) {
			assertEquals(expected, StarRating.interpretRange(r));
		}
	}
}
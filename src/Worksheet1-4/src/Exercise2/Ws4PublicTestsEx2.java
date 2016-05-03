package Exercise2;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Public tests for Ex2.
 *
 * @author Alexandros Evangelidis
 ** @date 2015-11-09
 */

public class Ws4PublicTestsEx2 {

	private PGStudent john, mary;
	private UGStudent jack, sam, nick;

	@Before
	public void setUp() {

		john = new PGStudent("John", "23123");
		mary = new PGStudent("Mary", "23232");

		jack = new UGStudent("Jack", "23131");
		sam = new UGStudent("Sam", "33121");
		nick = new UGStudent("Nick", "443131");
	}

	@Test
	public void test1() {

		boolean expected1 = true;
		boolean result1 = john.passedSWS(51.0, 50.0, 50.0);

		boolean expected2 = false;
		boolean result2 = mary.passedSWS(40, 40, 80);

		boolean expected3 = true;
		boolean result3 = mary.passedSWS(49, 49, 100);

		assertEquals(expected1, result1);
		assertEquals(expected2, result2);
		assertEquals(expected3, result3);

	}

	@Test
	public void test2() {

		boolean expected1 = false;
		boolean result1 = jack.passedSWS(39, 40.0, 40.0);

		boolean expected2 = true;
		boolean result2 = sam.passedSWS(40, 40, 80);

		boolean expected3 = true;
		boolean result3 = nick.passedSWS(39, 39, 100);

		assertEquals(expected1, result1);
		assertEquals(expected2, result2);
		assertEquals(expected3, result3);
	}

}
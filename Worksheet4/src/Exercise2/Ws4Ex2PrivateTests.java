package Exercise2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Ws4Ex2PrivateTests {

	private UGStudent tim, sam;
	private PGStudent john, jane;

	@Before
	public void setUp() {
		tim = new UGStudent("Tim Doe", "2312312");
		sam = new UGStudent("Sam Doe", "3123123");
		john = new PGStudent("John Doe", "1231231");
		jane = new PGStudent("Jane Doe", "3213213");
	}

	@Test // GETTERS & SETTERS
	public void test1() {
		String expectedName = "Tim Doe";
		String expectedRegistrationNumber = "2312312";
		String expectedName1 = "Sam Doe";
		String expectedRegistrationNumber1 = "3123123";
		String expectedName2 = "John Doe";
		String expectedRegistrationNumber2 = "1231231";
		String expectedName3 = "Jane Doe";
		String expectedRegistrationNumber3 = "3213213";

		assertEquals(expectedName, tim.getName());
		assertEquals(expectedRegistrationNumber, tim.getRegistrationNumber());
		assertEquals(expectedName1, sam.getName());
		assertEquals(expectedRegistrationNumber1, sam.getRegistrationNumber());
		assertEquals(expectedName2, john.getName());
		assertEquals(expectedRegistrationNumber2, john.getRegistrationNumber());
		assertEquals(expectedName3, jane.getName());
		assertEquals(expectedRegistrationNumber3, jane.getRegistrationNumber());

		tim.setName("Tam Doe");
		sam.setName("Pam Doe");
		john.setName("Joe Doe");
		jane.setName("Jenny Doe");
		assertEquals("Tam Doe", tim.getName());
		assertEquals("Pam Doe", sam.getName());
		assertEquals("Joe Doe", john.getName());
		assertEquals("Jenny Doe", jane.getName());
	}

	@Test // UGSTUDENT PASSEDSWS
	public void test4() {
		assertEquals(tim.passedSWS(40, 40, 39), false);
		assertEquals(tim.passedSWS(40, 40, 40), true);
	}

	@Test // PGSTUDENT PASSEDSWS
	public void test5() {
		assertEquals(john.passedSWS(40, 40, 40), false);
		assertEquals(john.passedSWS(50, 50, 49), false);
		assertEquals(john.passedSWS(50, 50, 50), true);
	}

}
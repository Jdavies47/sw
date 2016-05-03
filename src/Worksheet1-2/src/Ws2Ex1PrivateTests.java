import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ws2Ex1PrivateTests {

	private ClubMember c1;

	@Before
	public void setUp() {
		c1 = new ClubMember("John","Smith",2005);	
	}

	@Test
	// testing setter methods
	public void test1() {

		ClubMember c1 = new ClubMember("James","Bond",1940);

		c1.setFirstName("Julius");
		c1.setSurname("Caesar");
		c1.setYearOfJoining(-100);

		assertEquals("Julius",c1.getFirstName());
		assertEquals("Caesar",c1.getSurname());
		assertEquals(-100,c1.getYearOfJoining());
	}

	@Test
	// testing if getters copy the exact values from one instance to another
	public void test2() {

		ClubMember c2 = new ClubMember("Michael","Jackson",1958);		
		ClubMember c3 = new ClubMember(c2.getFirstName(),c2.getSurname(),c2.getYearOfJoining());

		assertEquals("Michael",c3.getFirstName());
		assertEquals("Jackson",c3.getSurname());
		assertTrue(c3.equals(c2));
	}

	@Test
	// tests getters & setters
	public void test3() {

		c1.setFirstName("Marie");
		c1.setSurname("Curie");
		c1.setYearOfJoining(1867);

		ClubMember c2 = new ClubMember("Scooby","Doo",1969);

		c2.setFirstName(c1.getFirstName());
		c2.setSurname(c1.getSurname());
		c2.setYearOfJoining(c1.getYearOfJoining());

		ClubMember c3 = new ClubMember("Bob","Dylan",1941);

		assertEquals(1941,c3.getYearOfJoining());
		assertEquals("Curie",c2.getSurname());
		assertFalse(c3.equals(c2));
	}

	@Test
	// tests setters
	public void test4() {

		c1.setFirstName("");
		c1.setSurname("");
		c1.setYearOfJoining(0);

		ClubMember c2 = new ClubMember("","",0);

		assertEquals("",c2.getFirstName());
		assertEquals("",c2.getSurname());
		assertEquals(0,c2.getYearOfJoining());
		assertTrue(c1.equals(c2));


	}

	@Test
	// tests setters
	public void test5() {
		
		ClubMember c2 = new ClubMember("Richard","Starkey",1940);
		
		assertFalse(c1.equals(c2));
		
		c2.setFirstName("Ringo");
		c2.setSurname("Starr");
		
		ClubMember c3 = new ClubMember(c2.getFirstName(),c2.getSurname(),c2.getYearOfJoining());

		assertTrue(c3.equals(c2));
		assertFalse(c1.equals(c2));
		assertFalse(c1.equals(c3));
	}

}

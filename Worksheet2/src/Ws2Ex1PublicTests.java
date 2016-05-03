import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**Public tests for Ex1.
 *
 * @author Alexandros Evangelidis
 * @date 2015-10-12
 */

public class Ws2Ex1PublicTests {

	private ClubMember c1,c2,c3,c4,c5;
	
	@Before
	public void setUp() {
	 c1 = new ClubMember("John","Smith",2005);	
	}
	
	@Test
	public void test1() {
	
		c1.setFirstName("Nick");
	
		assertEquals("Nick",c1.getFirstName());
		assertEquals("Smith",c1.getSurname());
		assertEquals(2005,c1.getYearOfJoining());
	}

	@Test
	public void test2() {
		
		c1.setSurname("Jones");
		
		assertEquals("John",c1.getFirstName());
		assertEquals("Jones",c1.getSurname());
		assertEquals(2005,c1.getYearOfJoining());
	}

	@Test
	public void test3() {
		
		c1.setYearOfJoining(2010);
		
		assertEquals("John",c1.getFirstName());
		assertEquals("Smith",c1.getSurname());
		assertEquals(2010,c1.getYearOfJoining());
	}
	
	@Test
	public void test4() {
		c1.setFirstName("Nick");
		c1.setSurname("Jones");
		c1.setYearOfJoining(1999);
		
		assertEquals("Nick",c1.getFirstName());
		assertEquals("Jones",c1.getSurname());
		assertEquals(1999,c1.getYearOfJoining());
	}

	@Test
	public void test5() {
		c2 = new ClubMember("Mary", "Duck", 2010);
		c3 = new ClubMember ("John","Smith",2005);
		c4 = new ClubMember("John","Smith",1996);
		c5 = new ClubMember("John","Smmith",1995);
		
		assertFalse(c1.equals(c2));
		assertTrue(c1.equals(c3));
		assertFalse(c1.equals(c4));
		assertFalse(c1.equals(c5));
	}
	
}
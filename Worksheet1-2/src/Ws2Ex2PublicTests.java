import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/** Public tests for Ex2.
 * 
 * @author Alexandros Evangelidis
 * @date 2015-10-12
 */

public class Ws2Ex2PublicTests {

	private Student s1,s2,s3;
	
	@Before
	public void setUp() {
		
	s1 = new Student("John", "male", "05721", "MSc Computer Science");
	}
	
	
	@Test
	public void test1() {
		
		s1.setName("Jack Smith");
		s1.setStudentID("0000");
		
		assertEquals("Jack Smith",s1.getName());
		assertEquals("0000",s1.getStudentID());
		assertEquals("MSc Computer Science",s1.getDegreeProgramme());
	}


	@Test
	public void test2() {
		
		s1.setName("Jack Smith");
		s1.setStudentID("0000");
		
		assertEquals("Jack Smith",s1.getName());
		assertEquals("0000",s1.getStudentID());
		assertEquals("MSc Computer Science",s1.getDegreeProgramme());
	}


	@Test
	public void test3() {
		
		s1.setName("Mary Jones");
		s1.setGender("female");
		s1.setStudentID("0564");;
		s1.setDegreeProgramme("History");
		
		String expected = "[Mary Jones, female, ID: 0564, History]";
		
		assertEquals(expected,s1.toString());	
	}
	
	
	@Test
	public void test4() {
		
		s1.setName("Mary Jones");
		s1.setGender("female");
		s1.setStudentID("0564");;
		s1.setDegreeProgramme("History");
		
		s2 = new Student("Mary jones", "female", "0564", "History");
		s3 = new Student("Mary Jones", "female", "0564", "History");
		
		assertFalse(s1.equals(s2));
		assertTrue(s1.equals(s3));
	}

}
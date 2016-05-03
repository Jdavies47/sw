import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ws2Ex2PrivateTests {

	private Student s1;

	@Before
	public void setUp() {

		s1 = new Student("John", "male", "05721", "MSc Computer Science");
	}

	@Test
	// tests getters retrieving values from other objects
	public void test1() {

		Student s2 = new Student(s1.getName(),s1.getGender(),s1.getStudentID(),s1.getDegreeProgramme());
		Student s3 = new Student(s1.getName(),s2.getGender(),s1.getStudentID(),s2.getDegreeProgramme());
		Student s4 = new Student(s1.getName(),s2.getGender(),s3.getStudentID(),s1.getDegreeProgramme());

		assertTrue(s1.equals(s3));
		assertTrue(s3.equals(s1));
		assertTrue(s2.equals(s4));
		assertTrue(s4.equals(s2));
		
	}	

	@Test
	// tests if lowercase & uppercase spelling or misspelt input is registered as different
	public void test2() {

		assertTrue(s1.getName().equals("John"));
		assertFalse(s1.getName().equals("john"));
		assertFalse(s1.getName().equals("Jon"));
		assertFalse(s1.getDegreeProgramme().equals("MSC COMPUTER SCIENCE"));

	}	

	@Test
	// tests getters & setters
	public void test3() {
		
		Student s2 = new Student("Amy","female","25635","MSc Mathematics");
		Student s3 = new Student("Amy","female","25635","MSc Mathematics");
		
		assertTrue(s2.equals(s3));
		assertFalse(s1.equals(s2));
		assertTrue(s1.getDegreeProgramme().equals("MSc Computer Science"));
		assertTrue(s2.getGender().equals("female"));

	}	

	@Test
	// testing if difference registered only in a single variable among 4 objects registers unequal or not
	public void test4() {

		Student s2 = new Student("James","male","12345","BA English");
		Student s3 = new Student("James","male","23456","BA English");
		Student s4 = new Student("James","male","34567","BA English");
		Student s5 = new Student("James","male","45678","BA English");
		
		assertFalse(s1.equals(s2));
		assertFalse(s2.equals(s3));
		assertFalse(s3.equals(s4));
		assertFalse(s4.equals(s5));
		
	}	

	@Test
	// testing setters
	public void test5() {
		
		Student s2 = new Student("James","male","12345","BA English");
		Student s3 = new Student("James","male","12345","BA German");

		s1.setDegreeProgramme("BA English");
		s2.setDegreeProgramme("BA German");
		
		
		assertFalse(s1.getDegreeProgramme().equals(s2.getDegreeProgramme()));
		assertTrue(s3.equals(s2));
	}
}

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/** Public tests for Ex4.
 *
 * @author Alexandros Evangelidis
 * @date 2015-10-12
 */

public class Ws2Ex4PublicTests {

	private Employee emp1;
    private double precision =0.0000001;
	
	@Before
	public void setUp() {
		emp1 = new Employee("John", 20.7, 25);
               
	}
	
	
	@Test
	public void test1() {
	
		emp1.setName("Jim");
		emp1.setHourlySalary(30.4);
		emp1.setNumberOfHours(29);
		
		assertEquals("Jim",emp1.getName());
		assertEquals(30.4,emp1.getHourlySalary(),precision);
		assertEquals(29,emp1.getNumberOfHours());
	}

	
	@Test
	public void test2() {
	
		emp1.setHourlySalary(40.4);
		emp1.setNumberOfHours(29);
		
		assertEquals(1171.6, emp1.monthlySalary(),precision);
	}

	@Test
	public void test3() {
	
		emp1.setHourlySalary(30.5);
		emp1.setNumberOfHours(52);
		
		assertEquals(1586, emp1.monthlySalary(),precision);
	
		emp1.increaseSalary(5.4);
	
		assertEquals(1671.644, emp1.monthlySalary(),precision);
	
	}
	@Test
	public void test4() {
	
		emp1.setHourlySalary(30.5);
		emp1.setNumberOfHours(52);
		
		emp1.increaseSalary(5.4);
		emp1.increaseSalary(10.5);
		assertEquals(1847.166619, emp1.monthlySalary(), 10*precision);
	}
}
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ws2Ex4PrivateTests {

	private Employee emp1, emp2;
	private double precision = 0.0000001;

	@Before
	public void setUp() {
		emp1 = new Employee("John", 20, 25);
		emp2 = new Employee("Jane", 25, 20);
	}

	@Test
	// testing the monthlySalary method: whether two different objects different values (20*25 vs 25*20) return the same values
	public void test1() {

		assertEquals(emp1.monthlySalary(),emp2.monthlySalary(),precision);
	}

	@Test
	// testing monthlySalary method & increaseSalary methods: whether they return the same values operating with different objects different values
	// (20*25 + 10% salary increase vs 25*20 + 10% salary increase)
	public void test2() {

		emp1.increaseSalary(10);
		emp2.increaseSalary(10);

		assertEquals(emp1.monthlySalary(), emp2.monthlySalary(),precision);
	}

	@Test
	// testing increaseSalary method & precision of addition of double type values
	public void test3() {

		emp1.increaseSalary(15);
		emp2.increaseSalary(25);

		assertEquals(1200, emp2.monthlySalary()+emp1.monthlySalary(),precision);

	}
	
	@Test
	// testing the precision of the increaseSalary method to the 0.0000001
	public void test4() {

		emp1.increaseSalary(0.0000001);

		assertEquals(20.00000002, emp1.getHourlySalary(),precision);
		assertEquals(500.0000005, emp1.monthlySalary(),precision);
	}
	
	@Test
	// testing whether a 0% salary increase returns a valid value or not
	public void test5() {
		
		emp1.increaseSalary(0);
		
		assertEquals(500, emp1.monthlySalary(),precision);
	}
	
	@Test
	// testing whether the increaseSalary method could just as well be used to decrease salaries by using negative numbers
	public void test6() {
		
		emp1.increaseSalary(-10);
		
		assertEquals(450, emp1.monthlySalary(),precision);
	}
}
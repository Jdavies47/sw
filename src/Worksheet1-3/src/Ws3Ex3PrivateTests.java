/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 2: Exercise 3: PRIVATE TESTS
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Ws3Ex3PrivateTests {

	private double[] salaryJane = { 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000 };
	private double[] salaryJim = { 1000, 1000, 1000, 1000, 1000, 1000,  1000,  1000,  1000,  1000,  1000,  1000 };
	private double[] salaryTim = { 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0 };
	private double precision = 0.000001;
	private Employee jane, jim, tim;
	private AllEmployees allEmployees;

	@Before
	public void setUp() {
		jane = new Employee("Jane Doe", "CS Bham", salaryJane);
		jim = new Employee("Jim Doe", "CS Bham", salaryJim);
		tim = new Employee("Tim Lazy", "Home", salaryTim);
		allEmployees = new AllEmployees();
	}

	@Test
	public void test1() {
		assertEquals("Jane Doe", jane.getName());
		assertEquals("CS Bham", jane.getAddress());

		double[] expectedSalariesJane = { 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000 };
		assertArrayEquals(expectedSalariesJane, jane.getSalaries(), precision);
	}

	@Test
	public void test2() {

		int expectedMonthsJaneWorked = 12;
		int expectedMonthsJimWorked = 12;
		int expectedMonthsTimWorked = 0;

		assertEquals(expectedMonthsJaneWorked, jane.monthsWorked());
		assertEquals(expectedMonthsJimWorked, jim.monthsWorked());
		assertEquals(expectedMonthsTimWorked, tim.monthsWorked());
	}

	@Test
	public void test3() {

		double expectedJaneAnnualSalary = 12000000.0;
		double expectedJimAnnualSalary = 12000.0;
		double expectedTimAnnualSalary = 0.0;

		assertEquals(expectedJaneAnnualSalary, jane.annualSalary(), precision);
		assertEquals(expectedJimAnnualSalary, jim.annualSalary(), precision);
		assertEquals(expectedTimAnnualSalary, tim.annualSalary(), precision);
	}

	@Test
	public void test4() {
		double[] salaryJaneUpdated = { 500000, 500000, 500000, 500000, 500000, 500000, 500000, 500000, 500000, 500000, 500000, 500000 };
		jane.setSalaries(salaryJaneUpdated);

		double expectedJaneAnnualSalary = 6000000.0;
		assertEquals(expectedJaneAnnualSalary, jane.annualSalary(), precision);

		String expected = "Jane Doe @ CS Bham earning 500000.0 500000.0 500000.0 500000.0 500000.0 500000.0 500000.0 "
				+ "500000.0 500000.0 500000.0 500000.0 500000.0 ";
		assertEquals(expected, jane.toString());
	}

	@Test
	public void test5() {
		allEmployees.add(jane);
		double expectedAvgMonthlySalary = 1000000.0;
		assertEquals(expectedAvgMonthlySalary,
				allEmployees.averageMonthlySalary(), precision);

		allEmployees.add(jim);
		double expectedAvgMonthlySalary1 = 500500.0;
		assertEquals(expectedAvgMonthlySalary1,
				allEmployees.averageMonthlySalary(), precision);

		allEmployees.add(tim);
		double expectedAvgMonthlySalary2 = 500500.0;
		assertEquals(expectedAvgMonthlySalary2,	allEmployees.averageMonthlySalary(), precision);

		allEmployees.delete(jane);
		double expectedAvgMonthlySalary3 = 1000.0;
		assertEquals(expectedAvgMonthlySalary3,
				allEmployees.averageMonthlySalary(), precision);

	}

}

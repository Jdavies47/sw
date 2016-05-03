import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Public tests for Ex3.
 * @author Alexandros Evangelidis
 * @date 2015-10-26
 */

public class Ws3Ex3PublicTests {

	private double[] salaryJohn = { 1000, 1000, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 1500 };
	private double[] salaryMary = { 1100, 1100, 1100, 1100, 1100, 1100, 1100, 1110, 1100, 1100, 1100, 1100 };
	private double precision = 0.000001;
	private Employee john, mary;
	private AllEmployees allEmployees;

	@Before
	public void setUp() {
		john = new Employee("John Smith", "CS Bham", salaryJohn);
		mary = new Employee("Mary Jones", "CS Bham", salaryMary);
		allEmployees = new AllEmployees();
	}

	@Test
	public void test1() {
		assertEquals("John Smith", john.getName());
		assertEquals("CS Bham", john.getAddress());

		double[] expectedSalariesJohn = { 1000, 1000, 1000, 0, 0, 0, 0, 0, 0, 0,	0, 1500 };
		assertArrayEquals(expectedSalariesJohn, john.getSalaries(), precision);
	}

	@Test
	public void test2() {

		int expectedMonthsJohnWorked = 4;
		int expectedMonthsMaryWorked = 12;

		assertEquals(expectedMonthsJohnWorked, john.monthsWorked());
		assertEquals(expectedMonthsMaryWorked, mary.monthsWorked());
	}

	@Test
	public void test3() {

		double expectedJohnAnnualSalary = 4500.0;
		double expectedMaryAnnualSalary = 13210.0;

		assertEquals(expectedJohnAnnualSalary, john.annualSalary(), precision);
		assertEquals(expectedMaryAnnualSalary, mary.annualSalary(), precision);
	}

	@Test
	public void test4() {
		double[] salaryJohnUpdated = { 500, 500, 1000, 0, 0, 300, 0, 0, 0, 0, 0, 1500 };
		john.setSalaries(salaryJohnUpdated);

		double expectedJohnAnnualSalary = 3800.0;
		assertEquals(expectedJohnAnnualSalary, john.annualSalary(), precision);

		String expected = "Mary Jones @ CS Bham earning 1100.0 1100.0 1100.0 1100.0 1100.0 1100.0 1100.0 "
				+ "1110.0 1100.0 1100.0 1100.0 1100.0 ";
		assertEquals(expected, mary.toString());
	}

	@Test
	public void test5() {
		allEmployees.add(john);
		double expectedAvgMonthlySalary = 1125.0;
		assertEquals(expectedAvgMonthlySalary,
				allEmployees.averageMonthlySalary(), precision);

		allEmployees.add(mary);
		double expectedAvgMonthlySalary1 = 1106.875;
		assertEquals(expectedAvgMonthlySalary1,
				allEmployees.averageMonthlySalary(), precision);

		allEmployees.add(john);
		double expectedAvgMonthlySalary2 = 1110.5;
		assertEquals(expectedAvgMonthlySalary2,	allEmployees.averageMonthlySalary(), precision);

		allEmployees.delete(john);
		double expectedAvgMonthlySalary3 = 1106.875;
		assertEquals(expectedAvgMonthlySalary3,
				allEmployees.averageMonthlySalary(), precision);

	}

}
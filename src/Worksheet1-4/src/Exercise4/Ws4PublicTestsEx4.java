package Exercise4;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// import Customer;

/**
 * Public tests for Ex4.
 *
 * @author Alexandros Evangelidis
 ** @date 2015-11-09
 */

public class Ws4PublicTestsEx4 {

	private Customer c1, c2;
	private BankAccount bAc1;
	private BankAccountWithOverdraft bAc2;

	@Before
	public void setUp() {

		// in this exercise you can use the Customer class
		// as an auxiliary class found in:
		// https://www.cs.bham.ac.uk/internal/courses/java/msc/handouts/1-06/Customer.java
		c1 = new Customer("Jim", "14 South East Road", "343311");
		c2 = new Customer("Jack", "CS Bham", "24141");
		bAc1 = new BankAccount(c1, "123456788", "sesame open");
		bAc2 = new BankAccountWithOverdraft(c2, "123456789", "sesame open", 500);
	}

	@Test
	public void test1() {

		bAc1.deposit(500);
		bAc1.withdraw(501, "sesame open");

		long expected = 500;
		long result = bAc1.getBalance();
		assertEquals(expected, result);

	}

	@Test
	public void test2() {

		bAc1.deposit(500);
		bAc1.withdraw(500, "sesameopen");

		long expected = 500;
		long result = bAc1.getBalance();
		assertEquals(expected, result);

	}

	@Test
	public void test3() {

		bAc2.deposit(500);
		bAc2.withdraw(501, "sesame open");

		long expected = -1;
		long result = bAc2.getBalance();
		assertEquals(expected, result);

	}

	@Test
	public void test4() {

		bAc2.deposit(500);
		bAc2.withdraw(501, "sesameopen");

		long expected = 500;
		long result = bAc2.getBalance();
		assertEquals(expected, result);

	}

}
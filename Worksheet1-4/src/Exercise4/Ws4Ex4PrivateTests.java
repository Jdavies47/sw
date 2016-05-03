package Exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Ws4Ex4PrivateTests {

	private Customer c1;
	private BankAccount regularAccount;
	private BankAccountWithOverdraft AccountWithOverdraft;

	@Before
	public void setUp() {
		c1 = new Customer("John Doe", "1 Whatever Road", "123123123");
		regularAccount = new BankAccount(c1, "123456789", "john123");
		AccountWithOverdraft = new BankAccountWithOverdraft(c1, "234567891", "john123", 500);
	}

	@Test // TESTING IF MAXWITHDRAWABLE() BROKE THE REGULAR BANKACCOUNT CLASS
	public void test1() {
		regularAccount.deposit(1000);
		regularAccount.withdraw(1001, "john123");
		long expected = 1000;
		long actual = regularAccount.getBalance();
		assertEquals(expected, actual);
	}

	@Test // TESTING IF MAXWITHDRAWABLE() BROKE THE REGULAR BANKACCOUNT CLASS
	public void test2() {
		regularAccount.deposit(1000);
		regularAccount.withdraw(500, "john123");
		long expected = 500;
		long actual = regularAccount.getBalance();
		assertEquals(expected, actual);

	}

	@Test // TESTING IF OVERDRAFT ACCOUNTS WORK
	public void test3() {
		AccountWithOverdraft.deposit(1000);
		AccountWithOverdraft.withdraw(1500, "john123");
		long expected = -500;
		long actual = AccountWithOverdraft.getBalance();
		assertEquals(expected, actual);
	}

	@Test // TESTING IF OVERDRAFT ACCOUNTS ALLOW WITHDRAWALS BEYOND OVERDRAFT LIMITS
	public void test4() {
		AccountWithOverdraft.deposit(1000);
		AccountWithOverdraft.withdraw(1501, "john123");
		long expected = 1000;
		long actual = AccountWithOverdraft.getBalance();
		assertEquals(expected, actual);

	}

}
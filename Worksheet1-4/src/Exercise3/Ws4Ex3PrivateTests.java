package Exercise3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Ws4Ex3PrivateTests {

	private PerishableGoods milk;
	private Goods table;
	private Customer VeryBigCompany;
	private Customer PoorLittleCompany;
	double precision = 0.0000001;
	
	@Before
	public void setUp() {
		milk = new PerishableGoods("1234", 100, true, 300);
		table = new Goods("2341", 200, true);
		VeryBigCompany = new Customer("The Big and Rich Company", "Rich Lane 1", 5000);
		PoorLittleCompany = new Customer("The Poor Tiny Company", "Shabby Row 1", 700);
	}

	@Test
	public void test1() {
		// TESTS GETTERS AND SETTERS for perishable goods
		milk.setOrderCode("5555");
		milk.setBestBeforeDay(200);
		milk.setAvailability(false);
		milk.setPrice(600);

		String expectedOrderCode = "5555";
		int expectedBestBeforeDay = 200;
		boolean expectedAvailability = false;
		int expectedPrice = 600;

		String actualOrderCode = milk.getOrderCode();
		int actualBestBeforeDay = milk.getBestBeforeDay();
		boolean actualAvailability = milk.isAvailability();
		int actualPrice = milk.getPrice();

		assertEquals(expectedOrderCode, actualOrderCode);
		assertEquals(expectedBestBeforeDay, actualBestBeforeDay);
		assertEquals(expectedAvailability, actualAvailability);
		assertEquals(expectedPrice, actualPrice);
	}

	@Test
	public void test2() {
		// TESTS GETTERS AND SETTERS for non-perishable goods
		table.setOrderCode("63463246");
		table.setAvailability(false);
		table.setPrice(76543);

		String expectedOrderCode = "63463246";
		boolean expectedAvailability = false;
		int expectedPrice = 76543;

		String actualOrderCode = table.getOrderCode();
		boolean actualAvailability = table.isAvailability();
		int actualPrice = table.getPrice();

		assertEquals(expectedOrderCode, actualOrderCode);
		assertEquals(expectedAvailability, actualAvailability);
		assertEquals(expectedPrice, actualPrice);
	}

	@Test
	public void test3() {
		// TESTS PERISHABLE GOODS' SELLABILITY
		boolean expected = false;
		boolean actual = milk.sellable();
		assertEquals(expected, actual);
	}

	@Test
	public void test4() {
		// TESTS GETTERS AND SETTERS for Customers
		VeryBigCompany.setAddress("some other street 1");
		VeryBigCompany.setTurnOver(13);
		VeryBigCompany.setName("some other name");

		String expectedAddress = "some other street 1";
		int expectedTurnOver = 13;
		String expectedName = "some other name";
		boolean expectedGoldStatus = false;
		
		String actualAddress = VeryBigCompany.getAddress();
		int actualTurnOver = VeryBigCompany.getTurnOver();
		String actualName = VeryBigCompany.getName();
		boolean actualGoldStatus = VeryBigCompany.isGoldStatus();
		
		assertEquals(expectedAddress, actualAddress);
		assertEquals(expectedTurnOver, actualTurnOver);
		assertEquals(expectedName, actualName);
		assertEquals(expectedGoldStatus, actualGoldStatus);		
	}
	
	@Test
	public void test5() {
		// TESTS IF DISCOUNTS ARE APPLIED THE RIGHT WAY
		int expected1 = 95;
		int expected2 = 100;
		double actual1 = VeryBigCompany.toPay(milk.getPrice());
		double actual2 = PoorLittleCompany.toPay(milk.getPrice());
		assertEquals(expected1, actual1, precision);
		assertEquals(expected2, actual2, precision);
	}
	
}
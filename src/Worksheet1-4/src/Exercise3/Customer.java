package Exercise3;
/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 4 Exercise 3
 * The program creates Customer objects (registering their names, addresses, turnover and whether or not they
 * qualify as golden customers, based on the size of their turnover). In case a customer has a turnover greater than 
 * 2000GBP, i.e. they qualify as golden customers, they receive a 5% discount on the price of goods (Goods objects
 * created by the Goods.class). 		
 */
public class Customer {

	/**
	 * VARIABLES
	 * String name stores the customer's name as a String
	 * String address stores the customer's address as a String
	 * int turnOver stores the customer's turnover as an integer
	 * boolean goldStatus stores whether the customer is a gold customer or not in a boolean
	 */
	String name, address;
	int turnOver;
	boolean goldStatus; 
	
	/**GETTER for the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**SETTER for the name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**GETTER for the address
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**SETTER for the address
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**GETTER for the turnover
	 * @return the turnOver
	 */
	public int getTurnOver() {
		return turnOver;
	}

	/**SETTER for the turnover
	 * @param turnOver the turnOver to set
	 */
	public void setTurnOver(int turnOver) {
		this.turnOver = turnOver;
	}

	/**GETTER for the goldStatus
	 * @return the goldStatus
	 */
	public boolean isGoldStatus() {
		if(turnOver>2000){
			return true;
		}
		else return false;
	}

	/**SETTER for the goldStatus
	 * @param goldStatus the goldStatus to set
	 */
	public void setGoldStatus(boolean goldStatus) {
		this.goldStatus = goldStatus;
	}

	/**
	 * CONSTRUCTOR to create Customer objects using variables:
	 * @param name to store the customer's name as a String
	 * @param address to store the customer's address as a String
	 * @param turnOver to store the customer's as an integer
	 */
	public Customer(String name, String address, int turnOver){		
		this.name = name;
		this.address = address;
		this.turnOver = turnOver;
		
		/**
		 * if customer's turnover is greater than 2000 GBP, their goldStatus is activated, 
		 * which means they receive a 5% discount on the price of Goods
		 */
		if(turnOver>2000){
			goldStatus = true;
		}
		else goldStatus = false;
	}
	
	/**
	 * METHOD to apply the 5% discount if the customer's goldStatus has been activated
	 * @param price the original, undiscounted price of the product
	 * @return the discounted price if applicable
	 */
	public double toPay(int price) {
		if(Customer.this.goldStatus==true){
			return price*0.95; // 5% discount
		} else return price;
	}
	
	// LOCAL TESTING
	public static void main(String[] args) {
		
		// TESTING CONSTRUCTOR LOCALLY
		Customer c1 = new Customer("Whatever Co.", "BHAM CS", 2000);
		if(c1.goldStatus==true){ System.out.println(c1.name + " is a gold status customer.");}
		else { System.out.println(c1.name + " is not a gold status customer.");}
		
		// TESTING toPay(int price) LOCALLY
		System.out.println("Price to pay: " + c1.toPay(100));
	}
}
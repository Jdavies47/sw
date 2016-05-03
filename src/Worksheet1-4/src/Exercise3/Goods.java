package Exercise3;

/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16 Software Workshop
 *         Worksheet 4: Exercise 3 The program creates Goods objects taking in
 *         basic information on products (their order codes, prices best before
 *         dates and information on their availability and whether they're
 *         perishable or not). It can determine whether or not the product is
 *         sellable today (dummy date provided by int today() method).
 */

/*
 * Q: "Is it advisable to have a subclass PerishableGood for perishable goods?
 * A: Yes. Perishability is not a quality that would ever change, so keeping a
 * variable for each object does not make practical sense. Any method or
 * function to perishable or non-perishable goods could then be dealt with
 * calling the entire sub-classes.
 * 
 * Q: "Is it advisable to have a subclass GoldStatus for gold status customers?"
 * A: No. Unlike perishability of goods produced by the company, the gold status
 * of a company is likely to change as the turnover of the company is likely to
 * change. If a company begins as a non-golden customer, and then is promoted to
 * being a golden customer, the object would have to be recreated in the other
 * class, which is troublesome and inefficient.
 */

public class Goods {

	/**
	 * VARIABLES: int price: to store the price of the product int
	 * bestBeforeDay: to store the ordinal number of the day in the year when
	 * the product will perish boolean availability: if the goods are available
	 * on stock (true or false) boolean perishable: whether or not the product
	 * in question is perishable (true or false)
	 */
	String orderCode;
	int price;
	boolean availability;
	
	/**
	 * @param orderCode
	 * @param price
	 * @param availability
	 * @param perishable
	 */
	public Goods(String orderCode, int price, boolean availability) {
		this.orderCode = orderCode;
		this.price = price;
		this.availability = availability;
	}

	/**
	 * METHOD to imitate date
	 * @return today's date's ordinal number as an integer
	 */
	public int today() {
		return 311;
	}

	/**
	 * GETTER for the orderCode
	 * @return the orderCode
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * SETTER for the orderCode
	 * @param orderCode the orderCode to set
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * GETTER for the price
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * SETTER for the price
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * GETTER for the availability
	 * @return the availability
	 */
	public boolean isAvailability() {
		return availability;
	}

	/**
	 * SETTER for the availability
	 * @param availability the availability to set
	 */
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
}
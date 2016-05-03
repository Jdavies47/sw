package Exercise3;

public class PerishableGoods extends Goods {
	
	/**
	 * VARIABLES
	 * int bestBeforeDay to store the ordinal number of the day when the product expires
	 */
	int bestBeforeDay;
	
	/**
	 * @param orderCode
	 * @param price
	 * @param availability
	 * @param bestBeforeDay
	 */
	public PerishableGoods(String orderCode, int price, boolean availability, int bestBeforeDay) {
		super(orderCode, price, availability);
		this.bestBeforeDay = bestBeforeDay;
	}

	/**
	 * @return the bestBeforeDay
	 */
	public int getBestBeforeDay() {
		return bestBeforeDay;
	}

	/**
	 * @param bestBeforeDay the bestBeforeDay to set
	 */
	public void setBestBeforeDay(int bestBeforeDay) {
		this.bestBeforeDay = bestBeforeDay;
	}

	/**
	 * METHOD to evaluate whether or not the product is sellable or not
	 * @return true if best before date is more than 14 days from today, false otherwise
	 */
	public boolean sellable() {
		if (getBestBeforeDay() < 15 && getBestBeforeDay() != 0) {
			if ((getBestBeforeDay() + 365) - (today() + 365) > 14) {
				return true;
			} else {
				return false;
			}
		} else {
			if (getBestBeforeDay() - 14 > today()) {
				return true;
			} else {
				return false;

			}
		}
	}

}

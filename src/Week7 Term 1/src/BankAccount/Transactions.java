package BankAccount;

public class Transactions {

	// VARIABLES
	private int dayOfYear; // ordinal number of the day in the year
	private String typeOfTransaction; //"initial balance", "deposit"
	private long amount;
	private long balance; // balance after the transaction
	
	// CONSTRUCTOR

	/**
	 * @return the dayOfYear
	 */
	public int getDayOfYear() {
		return dayOfYear;
	}

	/**
	 * @param dayOfYear
	 * @param typeOfTransaction
	 * @param amount
	 * @param balance
	 */
	public Transactions(int dayOfYear, String typeOfTransaction, long amount, long balance) {
		super();
		this.dayOfYear = dayOfYear;
		this.typeOfTransaction = typeOfTransaction;
		this.amount = amount;
		this.balance = balance;
	}

	/**
	 * @return the typeOfTransaction
	 */
	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}

	/**
	 * @return the amount
	 */
	public long getAmount() {
		return amount;
	}

	/**
	 * @return the balance
	 */
	public long getBalance() {
		return balance;
	}
}

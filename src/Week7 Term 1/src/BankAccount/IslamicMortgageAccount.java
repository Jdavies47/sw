package BankAccount;

public class IslamicMortgageAccount extends BankAccount {

	// VARIABLES
	private int months = 240;
	private long payout;
	private long cost;
	
	// CONSTRUCTOR
	public IslamicMortgageAccount(Customer customer, String accountNumber, String password, int months, long payout, long cost){
		
		super(customer, accountNumber, password);
		this.months = months;
		this.payout = payout;
		this.cost = cost;
		
		setBalance(0-(payout+cost));
		
		
		
	}
	/**
	 * @return the months
	 */
	public int getMonths() {
		return months;
	}
	/**
	 * @return the payout
	 */
	public long getPayout() {
		return payout;
	}
	/**
	 * @return the cost
	 */
	public long getCost() {
		return cost;
	}
	/**
	 * @param months the months to set
	 */
	public void setMonths(int months) {
		this.months = months;
	}
	/**
	 * @param payout the payout to set
	 */
	public void setPayout(long payout) {
		this.payout = payout;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(long cost) {
		this.cost = cost;
	}
	
	public int initialPayment(){
		return (int) (getPayout()+cost) % (getMonths() -1);
	}
	
	public int followUpPayment(){
		return (int) (getPayout()+cost) / (getMonths() -1);
	}
	
	@Override
	public void withdraw(long amount, String password){
		throw new UnsupportedOperationException();
	}
	
	public static void main(String[] args) {
		Customer carl = new Customer("Carl", "CS", "4141111");
		IslamicMortgageAccount carlsMortgage = new IslamicMortgageAccount(carl, "MA111", "sesame", 240, 90000, 10000);
		System.out.println(carlsMortgage);
		System.out.println(100000/239.0);
		System.out.println(carlsMortgage.initialPayment());
		System.out.println(carlsMortgage.followUpPayment());
		carlsMortgage.withdraw(200, "sesame");
	}
	
}

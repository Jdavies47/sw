
package BankAccount;

import java.util.ArrayList;

public class SavingsAccount extends BankAccount {
	
	// VARIABLES
	private double interestRate;
	private ArrayList<Transactions> transaction;

	// CONSTRUCTOR
	public SavingsAccount(Customer customer, String accountNumber, String password, double interestRate) {
		super(customer, accountNumber, password);
		this.interestRate = interestRate;
		this.transaction = new ArrayList<Transactions>();
//		transaction.add(1, "initial balance", 0,0);
	}
	
	public void deposit(long amount, int day){
		deposit(amount);
		Transactions trans = new Transactions(day, "deposit", amount, getBalance());
		transaction.add(trans);
	}
	
//	public int annualInterest(){
//		double interest = 0;
//		for (int i = 1; i < this.transactions){
//			interest +=
//		}
//	}
	
	public static void main(String[] args) {
		Customer catheryn = new Customer("Catheryn", "CS Lounge", "0121123123");
		SavingsAccount catherynsSavings = new SavingsAccount(catheryn, "Savings111", "sesame", 0.02);
		System.out.println(catherynsSavings);
		catherynsSavings.deposit(200);
		System.out.println(catherynsSavings);
	}
	


}

/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 2: Exercise 3
 * 
 * Program registers employees' information and creates Employee objects (from class Employee), it can add or remove Employee objects to and from
 * an array list (in class AllEmployees). The program can caluclate how many months each Employee was registered on the company's payroll, 
 * each Employee's annual salary, and calculate the average salary Employees were paid, accounting for months in which Employee's were not on
 * the company's payroll, i.e. such months are not counted in the averages.
 */

import java.util.Arrays;

public class Employee {

	/**
	 * variables:
	 * name of type String to store Employee's firstname + surname
	 * address of type String to store Employee's address
	 * salaries array of type double to store Employee's monthly salaries
	 */
	String name;
	String address;
	double[] salaries;

	/**
	 * Constructor used to create Employee objects
	 * @param name of type String to store Employee's firstname + surname
	 * @param address of type String to store Employee's address
	 * @param salaries array of type double to store Employee's monthly salaries
	 */
	public Employee(String name, String address, double[] salaries) {
		super();
		this.name = name;
		this.address = address;
		this.salaries = salaries;
	}

	/**
	 * getter to retrieve Employee's name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter to set Employee's name
	 * @param name set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter to retrieve Employee's address
	 * @return address of Employee
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * setter to set Employee's address
	 * @param address set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * getter to retrieve Employee's monthly salaries
	 * @return salaries array of Employee
	 */
	public double[] getSalaries() {
		return salaries;
	}

	/**
	 * setter to set Employee's salaries
	 * @param salaries set
	 */
	public void setSalaries(double[] salaries) {
		this.salaries = salaries;
	}

	/**
	 * Method to calculate the amount of months an Employee worked
	 * @return months (12 - months in which Employee's salary was zero, i.e. was not on the company's payroll)
	 */
	public int monthsWorked(){
		int months = salaries.length;	// the length of the array is assigned to integer months (in case it isn't 12)
		int i = 0;	// counter for a loop initialised
		int j = 0;	// counter to count idle months initialised

		// for loop evaluates how many months there are in the array where the salary equals zero, i.e. months that should not be considered as
		// working months, the amount is then subtracted from the length of the salary array 
		for (i = 0; i<salaries.length; i++){		// loop as many times as many months there are in the salaries array
			if(salaries[i] == 0){					// if current salary equals zero,
				j++;								// increment idle months by 1
			}
		}
		months = months - j;						// subtract idle months from total months
		return months;								// to return the amount of months actually worked

	}

	/**
	 * Method to calculate Employee's annual salary
	 * @return total of salaries in every month
	 */
	public double annualSalary(){
		double total = 0.0;		// total initialised
		int i = 0;					// counte initialised
		for (i = 0; i < salaries.length; i++ ){		// loop as many times as many entries the salaries array has
			total = total + salaries[i];			// add each salary to total
		}
		return total;
	}
	

	/**
	 * toString method to format Employee details
	 */
	public String toString() {
		String bracketsAndCommas = "[\\[\\,\\]]";		// initial square brackets, square brackets around each item and commas are 
														// defined as bracketsAndCommas
	    String arrayString = Arrays.toString(salaries).replaceAll(bracketsAndCommas, "");		// in order to be replaced by nothing
		return name + " @ " + address + " earning " + arrayString + " ";
	}
	
//	public String toString() {
//		return name + " @ " + address + " earning " + Arrays.deepToString(getSalaries());
//	}
}
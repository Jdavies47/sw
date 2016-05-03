/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 2: Exercise 4
 * The program registers and stores data on employees in 3 variables: a string for name (first name and surname),
 * a type double for storing employee's hourly salary and an integer type to store the amount of hours the employee
 * works in a month. The program allows the user to apply a salary increase calculation method on existing data, after which 
 * it outputs the newly calculated salary value.
 */

public class Employee {

	/*
	 * Field variables:
	 * 
	 * 			  name: The employee's name (first name + surname) as a String.
	 * 	  hourlySalary: The employee's hourly salary as a Double.
	 *   numberOfHours: The amount of hours an employee works per month as an Integer.
	 */
	private String name;
	private double hourlySalary;
	private int numberOfHours;

	/**
	 * Constructor assigns the following parameters to instances of Employee
	 * @param name assigns the employee's name (first name + surname).
	 * @param hourlySalary assigns the employee's hourly salary.
	 * @param numberOfHours assigns the amount of hours an employee works per month.
	 */
	public Employee(String name, double hourlySalary, int numberOfHours) {
		super();
		this.name = name;
		this.hourlySalary = hourlySalary;
		this.numberOfHours = numberOfHours;
	}

	/**
	 * Getter:
	 * @return retrieves Employee's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter:
	 * @return retrieves Employee's hourly salary.
	 */
	public double getHourlySalary() {
		return hourlySalary;
	}

	/**
	 * Getter:
	 * @return retrieves stored amount of hours an employee spends working per month.
	 */
	public int getNumberOfHours() {
		return numberOfHours;
	}

	/**
	 * Setter:
	 * @param name used to set Employee's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter:
	 * @param hourlySalary used to set Employee's hourly salary
	 */
	public void setHourlySalary(double hourlySalary) {
		this.hourlySalary = hourlySalary;
	}

	/**
	 * Setter:
	 * @param numberOfHours used to set the number of hours an Employee works in a month
	 */
	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	// Method used to calculate monthly salary (hourly salary * number of hours).
	public double monthlySalary () {
		return hourlySalary * numberOfHours;
	}

	// Method used to calculate increase in salary (takes increase % as an argument).
	public void increaseSalary(double percentage) {
		hourlySalary = hourlySalary * ( 1 + ( percentage / 100 ) );
	}

	// toString used to provide a template to format output.
	@Override
	public String toString() {
		return "---" + getName() + "--------------" + 
				"\n   Hourly salary: " + getHourlySalary() + 
				"\n Number of hours: " + getNumberOfHours() + 
				"\n  Monthly salary: " + monthlySalary() + ".\n";
	}

	// Beginning of output:
	public static void main(String[] args) {

		// Creating an Employee instance 'emp1'
		Employee emp1 = new Employee ("John Smith", 15, 160);

		// Displaying John's info (name, hourly salary, hours worked per month, monthly salary)
		System.out.println(emp1);

		// Increasing John's salary by 45% using the increaseSalary method (45 as its argument)
		emp1.increaseSalary(45);

		// Displaying John's updated salary info
		System.out.println(emp1);
	}
}
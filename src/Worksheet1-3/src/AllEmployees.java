/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 2: Exercise 3
 * 
 * Program registers employees' information and creates Employee objects (from class Employee), it can add or remove Employee objects to and from
 * an array list (in class AllEmployees). The program can caluclate how many months each Employee was registered on the company's payroll, 
 * each Employee's annual salary, and calculate the average salary Employees were paid, accounting for months in which Employee's were not on
 * the company's payroll, i.e. such months are not counted in the averages.
 */
import java.util.ArrayList;
public class AllEmployees {

	/**
	 * variables: ArrayList allEmployees, it only allows Employee objects to be added to the list
	 */
	ArrayList<Employee> allEmployees = new ArrayList<>();
	
	// constructor to create the AllEmployees object
	public AllEmployees(){
		allEmployees = new ArrayList<Employee>();
	}

	/**
	 * Method to add Employee to the AllEmployees list
	 * @param Employee added to the ArrayList
	 */
	public void add(Employee Employee){
		allEmployees.add(Employee);
	}

	/**
	 * Method to remove Employee from the AllEmployees list
	 * @param Employee removed from the ArrayList
	 */
	public void delete(Employee Employee){
		allEmployees.remove(Employee);
	}

	/**
	 * Method to calculate the average monthly salary of ALL Employees on the list of AllEmployees
	 * @return average
	 */
	public double averageMonthlySalary(){
		double total = 0.0;		// total double initialised
		int i = 0;					// first loop counter initialised
		int j = 0;					// second loop counter initialised
		int k = 0;					// counter to count the total amount of months is initialised

		for (i=0;i<allEmployees.size();i++){								// loops the list of employees through index: i
			for (j=0; j<allEmployees.get(i).getSalaries().length; j++){	// loops salaries of 'i'th employee
				if(allEmployees.get(i).getSalaries()[j] > 0){				// if 'i'th employee's 'j'th month's salary is greater than zero:
					total += allEmployees.get(i).getSalaries()[j];			//		- 'j'th month's salary is added to the total &
					k++;													// 		- 'k' counter of such months is incremented for the calculation of the average
				}
			}
		}
		return total / k;													// average = total sum / number of months
	}
}
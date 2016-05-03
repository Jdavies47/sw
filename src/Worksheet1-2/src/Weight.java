/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 2: Exercise 3
 * The program prompts for a user input: weight expressed in pounds. It then returns the originally inserted value, 
 * plus converted values in kilogrammes and ounces.
 */

// Importing Scanner for registering user input for conversion.
import java.util.Scanner;

public class Weight {

	/*
	 * public double type variable 'pound' used to register user input (public, since privacy is not an issue, and double
	 * to allow for more accurate, floating point input.
	 */
	public double pounds;
	private static Scanner input;

	/**
	 * Constructor 
	 * @param pounds used to create the object
	 */
	public Weight(double pounds) {
		super();
		this.pounds = pounds;
	}

	/**
	 * Getter:
	 * @return used to retrieve pounds
	 */
	public double getPounds() {
		return pounds;
	}

	/**
	 * Setter:
	 * @param pounds used to set value to pounds
	 */
	public void setPounds(double pounds) {
		this.pounds = pounds;
	}
	
	/**
	 * Method:
	 * @return value in KG multiplying the pounds value by 0.45359237
	 */
	public double poundsToKilograms() {
		return pounds*0.45359237;
	}
	
	/**
	 * Method:
	 * @return value in Oz multiplying the pounds value by 16
	 */
	public double poundsToOunces() {
		return pounds*16;
	}

	/**
	 * Getter:
	 * @return used to retrieve value in KG
	 */
	public double getKilograms() {
		return poundsToKilograms();
	}
	
	/**
	 * Getter:
	 * @return used to retrieve value in Oz
	 */
	public double getOunces() {
		return poundsToOunces();
	}

	// beginning of output:
	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		System.out.println("Hello. Input weight in lbs: ");
		// creating the object and registering user input as value for pounds
		Weight w1 = new Weight(input.nextDouble());
		
		// outputting original value and converted values
		System.out.println(w1.getPounds() + " lbs = " + w1.getOunces() + " oz = " + w1.getKilograms() + " kgs.");
	}
}
/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 2: Exercise 5
 * The program registers user input to create 2 fractions, adds, multiplies and compares them. It also calculates the 
 * fractions' rational values. The program does not include a complete simplify method yet.
 * 
 */

/*
 * Importing Scanner in order to register user input.
 */
import java.util.Scanner;

public class Fraction{

	/**
	 * Constructor assigns values as:
	 * @param numerator of the fraction
	 * @param denominator of the fraction
	 */
	public Fraction(int numerator, int denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/*
	 *Field variables: type integer numerator and denominator defined to be private
	 *		  Scanner: used to store user input
	 */
	private int numerator, denominator;
	private static Scanner input;

	/**
	 * Getter:
	 * @return numerator of fraction
	 */
	public int getNumerator() {
		return numerator;
	}

	/**
	 * Setter:
	 * @param numerator of fraction
	 */
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	/**
	 * Getter:
	 * @return denominator of the fraction
	 */
	public int getDenominator() {
		return denominator;
	}

	/**
	 * Setter:
	 * @param denominator of fraction (user input requested repeatedly in case user tries to enter zero in order to
	 * avoid trying to divide by zero)
	 */
	public void setDenominator(int denominator) {
		if (denominator == 0){
			while (denominator == 0){
				System.out.println("No division by 0. Please enter a non-zero value.");
				denominator = input.nextInt();
			}
		}
		this.denominator = denominator;
	}

	/**
	 * Method: used to add 2 fractions using the following formula:
	 * 			a/b + c/d = ( ( a * d ) + ( c * b ) ) / ( b * d )
	 * @param f2 is the fraction that's added to the first fraction
	 * @return result as a Fraction
	 */
	public Fraction add(Fraction f2){
		Fraction result = new Fraction((getNumerator()*f2.getDenominator())+(f2.getNumerator()*getDenominator()),getDenominator()*f2.getDenominator());
		return result;
	}

	/**
	 * Method: used to multiply 2 fractions using the following formula:
	 * 			a/b * c/d = ( a * c ) / ( b * d )
	 * @param f2 is the fraction by which the first fraction is multiplied 
	 * @return result as a Fraction
	 */
	public Fraction multiply(Fraction f2){
		Fraction multiply = new Fraction(getNumerator()*f2.getNumerator(),getDenominator()*f2.getDenominator());
		return multiply;
	}

	/**
	 * Method: used to calculate the fraction's rational value converting the numerator's and denominator's integers into doubles
	 * and simply calculating the division.
	 * @return type double rational value of fraction
	 */
	public double getRational(){
		double rationalNum = getNumerator(), rationalDen = getDenominator();
		return rationalNum/rationalDen;
	}

	/**
	 * Method: used to compare two fractions
	 * @param f2 is the fraction the first fraction is compared to
	 * @return type boolean: false in case the first fraction is smaller than the second fraction, true in case the second fraction is greater than or equal to the first fraction.
	 */
	public boolean greaterEqual(Fraction f2){
		if (getRational() <= f2.getRational()){
			return false;
		}
		else
			return true;
	}

	public Fraction simplify(){
		
		Fraction result = new Fraction(0,0);
		
		int simpNum = getNumerator();
		int simpDen = getDenominator();
		
		if (simpDen % simpNum == 0 || simpNum % simpDen ==0 ){
			while (simpDen % simpNum == 0 || simpNum % simpDen == 0) {
				if (simpDen >= simpNum) {
					simpDen = simpDen / simpNum;
				}
				else
					simpNum = simpDen;
			}
		}
		else {
		result.setNumerator(simpNum);
		result.setDenominator(simpDen);
		}
		result.setNumerator(simpNum);
		result.setDenominator(simpDen);
		
		return result;
	}

	/**
	 * toString method used to format fractions as numerator/denominator (separate them with the / )
	 */
	@Override
	public String toString() {
		return getNumerator() + "/" + getDenominator();
	}

	// beginning of output
	public static void main(String[] args) {

		// scanner used to register user input
		input = new Scanner(System.in);

		// fractions f1, f2 are initialised
		Fraction f1 = new Fraction(0,0);
		Fraction f2 = new Fraction(0,0);

		// user prompted to input first fraction's numerator
		System.out.print("Hello\n   Please enter the first fraction's numerator: ");

		// user input stored as the first fraction's numerator using the setNumerator method
		f1.setNumerator(input.nextInt());	

		// user prompted to input first fraction's denominator
		System.out.print(" Please enter the first fraction's denominator: ");

		// user input stored as the first fraction's denominator using the setDenominator method
		f1.setDenominator(input.nextInt());

		// user prompted to input second fraction's numerator
		System.out.print("  Please enter the second fraction's numerator: ");

		// user input stored as the second fraction's numerator using the setNumerator method
		f2.setNumerator(input.nextInt());

		// user prompted to input second fraction's denominator
		System.out.print("Please enter the second fraction's denominator: ");

		// user input stored as the second fraction's denominator using the setDenominator method
		f2.setDenominator(input.nextInt());

		// displaying the fractions using the toString method
		System.out.println("    The two fractions I'll be working with are: " + f1.toString() + " & " + f2.toString());

//		System.out.println("                  The two fractions simplified: " + f1.simplify() + ", " + f2.simplify());

		// displaying the fraction as a rational number using the getRational method
		System.out.println("         The two fractions as rational numbers: " + f1.getRational() + ", " + f2.getRational());

		// adding the two fractions using the add method
		System.out.println("                      Adding the two fractions: " + f1 + " + " + f2 + " = " + f1.add(f2));

		//		System.out.println("Simplifying the sum:                        " + (f1.add(f2)).simplify());

		// multiplying the two fractions using the multiply method
		System.out.println("                 Multiplying the two fractions: " + f1 + " * " + f2 + " = " + f1.multiply(f2));

		//		System.out.println("Simplifying the factor:                     " + (f1.multiply(f2)).simplify());

		// comparing the two fractions using the rational values using the getRational method
		if (f1.getRational() > f2.getRational()){

			// output if the first fraction is greater than the second fraction
			System.out.println("               Comparison of the two fractions: " + f1 + " > " + f2);
		}
		else if (f1.getRational() == f2.getRational()){
			
			// output if the first fraction equals the second fraction
			System.out.println("               Comparison of the two fractions: " + f1 + " = " + f2);
		}
		else

			// output if the second fraction is greater than the first fraction
			System.out.println("               Comparison of the two fractions: " + f1 + " < " + f2);
	}
}
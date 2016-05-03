/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 2: Exercise 2
 * The program performs calculations with individual digits of numbers entered, such as calculating the sum of the individual digits of any number entered,
 * or calculating which digit occurs most frequently or determining how proportionally frequent a certain digit is in an entered number
 */
public class DigitTotal {

	/**
	 * variables
	 * 'n' integer for storing the number entered
	 * 'sum' integer for storing the sum of digit added up
	 * 'max' integer for storing the end-of-range value for calculating averages and frequency
	 */
	int n;
	static int sum = 0;
	int max;

	/**
	 * Constructor using
	 * @param n integer for storing the number entered
	 * @param sum integer for storing the sum of the digits entered
	 */
	public DigitTotal(int n, int sum) {
		super();
		this.n = n;
		DigitTotal.sum = sum;
	}
/**
 * Method calculating the sum of the individual digits of any number entered
 * @param n integer is the number entered
 * @return is the sum of the individual digits
 */
	public static int digitTotal(int n){

		// changing negative value to positive value (absolute value)
		if ( n < 0 ) {
			n = n - ( 2 * n );
		}

		// resetting the value of sum to zero, in case method isn't called for the first time
		sum = 0; 

		// while the number is greater than zero, the remainder upon division by ten (i.e. last digit cut off) will be added to the sum
		while ( n > 0 ){
			sum = sum + ( n % 10 );
			n = n / 10;
		}
		return sum;
	}
/**
 * method to calculate the average of the digits used in all numbers ranging from zero to user-entered integer 'max'
 * @param max user entered end-of-range value until which numbers will be evalueated
 * @return average
 */
	public static double digitTotalAverage(int max){
		int[] digit = new int[max+1];						// digit array is created, its length is user entered 'max'
		int counter = 0;									// counter initialised
		double sum = 0;									// sum initialised
		double average = 0.0;								// average initialised
		for (counter = 0; counter < max +1 ; counter++){	// loops 0 - 'max' user-entered integer
			digit[counter] = counter;						// counter's value used as index of array
			sum = sum + digitTotal(digit[counter]);			// the digitTotal of current value of array is added to 'sum'
			if (counter != 0){								// no division by zero occurring
				average = sum / counter;
			}
		}
		average = sum / counter;							// average calculated by dividing 'sum' with the counter (the amount of members in the array)
		return average;										// returns average
	}

	/**
	 * method to calculate proportion of given value in range from zero to 'max'
	 * @param max end of range
	 * @param digitTotal is the value whose proportion the method calculates
	 * @return proportion of all occurrances
	 */
	public static double digitTotalFrequency(int max, int digitTotal){
		double proportion = 0.0;		// proportion initialised
		int[] digit = new int[max+1];	// array of 'max' length created 
		int counter = 0;				// counter initialised
		double occurrance = 0;			// occurrance variable initialised

		for (counter = 0; counter < max+1; counter++){  // looping from 0 to 'max'
			digit[counter] = counter;					 // array's current value equated to counter
			if(digitTotal(digit[counter])==digitTotal){
				occurrance++;							 // 'occurrance' counter incremented each time digitTotal of the array's current
														 // value equals digitTotal integer given by user
			}
		}

		proportion = occurrance/(max+1);				 // proportion is calculated by dividing occurrance by the end-of-range value +1
		return proportion;								 // proportion is returned
	}

	public static void main(String[] args) {
//		System.out.println(digitTotal(1));
//		System.out.println(digitTotalAverage(1));
		System.out.println(digitTotalFrequency(100000000,3));
	}
}

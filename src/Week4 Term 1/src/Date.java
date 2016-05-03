import java.util.Scanner;

/** Date is a class for the representation of dates in the form "3 October 2012"
 *  @author   Manfred Kerber
 *  @version  2015-10-06
 */
public class Date{
	private int    day;
	private String month;
	private int    year;
	private String weekDay;
	private static Scanner input;

	/**
	 * This constructor creates a date from the three parts: day,
	 * month, and year, which are an int, a String, and an int,
	 * respectively.
	 * @param day The day of the month in a date.
	 * @param month The month as a String, e.g. "January".
	 * @param year The year such as 2012.
	 */
	public Date (int    day, 
			String month, 
			int    year){
		this.day      = day;
		this.month    = month;
		this.year     = year;
		weekDay       = "unkown"; 
	}

	/* Now we write methods to get the parts of a Date,
	 * so called accessor methods.
	 */

	/** 
	 *  @return The day of a Date.
	 */
	public int getDay(){
		return day;
	}

	/** 
	 *  @return The month of a Date.
	 */
	public String getMonth(){
		return month;
	}

	/** 
	 *  @return The year of a Date .
	 */
	public int getYear(){
		return year;
	}

	/** 
	 *  @return The weekDay of a Date 
	 */
	public String weekDay(){
		return weekDay;
	}

	/** 
	 *  @return the print format of a Date, e.g., European style or American style
	 */
	public String toString(){
		return day + " " + month + " " + year;   // European way
		//return month + " " + day + ", " + year;   // American way
	}

	/* Now we write methods to set the parts of a Date,
	 * so called setters.
	 */

	/** 
	 *  @param day the day is set to newDay
	 */
	public void setDay(int day){
			this.day = day;
	}

	/** 
	 *  @param month the month is set to newMonth
	 */
	public void setMonth(String month){
		this.month = month;
	}

	/** 
	 *  @param year the year is set to newYear
	 */
	public void setYear(int year){
		this.year = year;
	}

	public static boolean isLeapYear(int year){
		if (year % 400 == 0){
			return false;
		}
		else if (year % 4 == 0){
			return true;
		}
		else return false;
	}

	public static boolean admissibleDay(int year, String month, int day){
		if (isLeapYear(year) == true && month.equals("February") && 1 <= day && day < 30){
			return true;
		}
		else if (
				month.equals("January") || 
				month.equals("March") || 
				month.equals("May") || 
				month.equals("July") || 
				month.equals("August") || 
				month.equals("October") || 
				month.equals("December") &&
				1 <= day && day <= 31) {
			return true;
				}
		else if (
				month.equals("April") || 
				month.equals("June") || 
				month.equals("September") || 
				month.equals("November") &&
				1 <= day && day < 30) {
			return true;
				}
		else return false;
	}

	public static boolean admissible(int day, String month, int year) {
		if (year > 0 &&	(
				month.equals("January") || 
				month.equals("February") || 
				month.equals("March") || 
				month.equals("April") || 
				month.equals("May") || 
				month.equals("June") || 
				month.equals("July") || 
				month.equals("August") || 
				month.equals("September") || 
				month.equals("October") || 
				month.equals("November") || 
				month.equals("December")) &&
				1 < day && 32 > day){
			return true;
		}
		else return false;
	}

	public static void main(String[] args) {
		Date d1 = new Date(0,"",0);
		input = new Scanner(System.in);
		System.out.print("Please set the day: ");
		d1.setDay(input.nextInt());
		System.out.print("Please set the month: ");
		d1.setMonth(input.next());
		System.out.print("Please set the year: ");
		d1.setYear(input.nextInt());
		System.out.println("The date you've entered is: " + d1.getDay() + ". " + d1.getMonth() + ", " + d1.getYear());
		if ( (admissible(d1.getDay(), d1.getMonth(), d1.getYear()) == true) && (admissibleDay(d1.getYear(), d1.getMonth(), d1.getDay()) == true) )
		{
			System.out.println("This date is admissible.");
		}
		else
			System.out.println("Sorry, the date is not admissible");
	}
}
/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 2: Exercise 1
 * The program registers and stores data on club members in 3 variables: first name, surname and year of joining the club.
 * After outputting an example 'John Smith' club member entry, the program prompts the user to enter a new surname which
 * then overwrites the existing surname with whatever the user enters.
 */

/*
 * Importing Scanner in order to register user 
 * input for the modification of existing data.
 */
import java.util.Scanner; 

public class ClubMember {

	/*
	 * Field variables:
	 * firstName: 		The club member's first name.
	 * surname: 		The club member's surname.
	 * yearOfJoining: 	The year in which the member joined the club.
	 */
	private String firstName;
	private String surname;
	private int yearOfJoining;
	private static Scanner input;

	/**
	 * Constructor assigns the values to the appropriate fields:
	 * @param firstName to be assigned the club member's first name.
	 * @param surname to be assigned the club member's surname.
	 * @param yearOfJoining is to be assigned to the year when the club member joined.
	 */
	public ClubMember (String firstName, String surname, int yearOfJoining) {
		this.firstName = firstName;
		this.surname = surname;
		this.yearOfJoining = yearOfJoining;
	}

	/**
	 * Getter:
	 * @return The club member's first name as a String.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Getter:
	 * @return The club member's surname as a String.
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Getter:
	 * @return The year the club member joined the club as an Integer. 
	 */
	public int getYearOfJoining() {
		return yearOfJoining;
	}

	/**
	 * Setter:
	 * @param newSurname is used to store club member's surname
	 */
	public void setSurname(String newSurname) {
		this.surname = newSurname;
	}

	/**
	 * Setter:
	 * @param newFirstName is used to store club member's surname
	 */
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}

	/**
	 * Setter:
	 * @param newYearOfJoining is used to store club member's year of joining
	 */
	public void setYearOfJoining(int newYearOfJoining) {
		this.yearOfJoining = newYearOfJoining;
	}

	// toString used to provide a template to format output.
	public String toString() {
		return "First name of club member: " + firstName + "\n"
				+ "   Surname of club member: " + surname + "\n"
				+ "             Member since: " + yearOfJoining + "\n";
	}

	/**
	 * Method used to compare whether any object's any value equals any other object's any value
	 * @param object is any object created by the constructor ClubMember
	 * @return type boolean. True if any object's any value equals any other object's any value.
	 */
	public boolean equals(ClubMember object) {
		if (	firstName.equals(object.getFirstName()) &&	
				surname.equals(object.getSurname()) && 
				yearOfJoining == object.getYearOfJoining())
			return true;
		else
			return false;
	}

	// Beginning of output:
	public static void main(String[] args) {

		input = new Scanner(System.in);

		// Registering John Smith as a club member.
		ClubMember c1 = new ClubMember("John", "Smith", 2005);

		System.out.println(c1);

		/*
		 * User prompt for the modification of a John Smith's surname. 
		 * Assigning the newly entered surname to overwrite the existing 
		 * surname using the setSurname method.
		 */
		System.out.println("Enter " + c1.getFirstName() + " " + c1.getSurname() + "'s " +
				"new surname: ");
		c1.setSurname(input.nextLine());

		// Output of newly modified data.
		System.out.println("\n" + c1);
	}
}
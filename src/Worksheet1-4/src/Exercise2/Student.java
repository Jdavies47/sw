package Exercise2;
/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16 Software Workshop
 *         Worksheet 4: Exercise 2 
 *         The Program includes a superclass (Student)
 *         and 2 sub-classes (UGStudent and PGStudent). The abstract Student
 *         class only includes generic variables (and their getters and setters)
 *         that all students have (name, registration number), and an abstract
 *         method (passedSWS) that is specified and applied in the sub-classes.
 */
public abstract class Student {

	/**
	 * VARIABLES:
	 * String name to store the student's name as a String;
	 * String registrationNumber to store the student's registration number (Student ID) as a String
	 */
	private String name;
	private String registrationNumber;

	/**GETTER METHOD for the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**SETTER METHOD for the name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**GETTER METHOD for the registrationNumber
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**SETTER METHOD for the registrationNumber
	 * @param registrationNumber
	 *            the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	/**
	 * ABSTRACT METHOD further specified in the sub-classes, to evaluate whether a student has passed the Software Workshop
	 * module or not.
	 * @param examination provides the result the student got at the exam in %
	 * @param cA provides the result of the student's continuous assessment in %
	 * @param team provides the result of the student's teamwork in %
	 * @return true if the student passes the module, false otherwise
	 */
	public abstract boolean passedSWS(double examination, double cA, double team);
}

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

public class PGStudent extends Student {
	/**
	 * @param examination the result the student got at the exam in %
	 * @param cA the result of the student's continuous assessment in %
	 * @param team the result of the student's teamwork in %
	 */
	public PGStudent(String name, String registrationNumber) {
		super();
		this.setName(name);
		this.setRegistrationNumber(registrationNumber);
	}
	/**
	 * METHOD to 
	 * evaluate whether a student has passed the Software Workshop module or not. If the weighted averages of the results
	 * at the exam, of the continuous assessment and of the team project are greater than or equal to 50 the student passes.
	 * @param examination provides the result the student got at the exam in %
	 * @param cA provides the result of the student's continuous assessment in %
	 * @param team provides the result of the student's teamwork in %
	 * @return true if weighted averages of the student are over or equal to 50%, false otherwise
	 */
	@Override
	public boolean passedSWS(double examination, double cA, double team) {
		if ((examination * 0.7) + (cA * 0.2) + (team * 0.1) >= 50) {
			return true;
		} else {
			return false;
		}
	}
}

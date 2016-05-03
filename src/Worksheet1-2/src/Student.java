/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 2: Exercise 2
 * The program outputs a list of registered students, displaying their relevant data in 4 variables: their names, genders, 
 * student IDs and degree programme are all stored as string. Set methods allow the modification of each.
 */

public class Student {

	/*
	 * Field variables:
	 * 
	 * 			  name: Name of student (first name + surname in one string).
	 * 			gender: Gender of student stored as a string
	 * 		 studentID: student ID of student stored as a string
	 * degreeProgramme: type of programme the student takes part in
	 */
	private String name;
	private String gender;
	private String studentID;
	private String degreeProgramme;

	/**
	 * Constructor assigns the values to the appropriate fields:
	 * @param name to be assigned the name of student (first name + surname in one string).
	 * @param gender to be assigned the gender of student.
	 * @param studentID to be assigned the student ID of student.
	 * @param degreeProgramme to be assigned the type of programme the student takes part in.
	 */
	public Student(String name, String gender, String studentID, String degreeProgramme) {
		super();
		this.name = name;
		this.gender = gender;
		this.studentID = studentID;
		this.degreeProgramme = degreeProgramme;
	}

	/**
	 * Getter:
	 * @return The student's name (first name + surname in one string).
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter:
	 * @return The student's gender as a String.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Getter:
	 * @return The student's student ID as a String.
	 */
	public String getStudentID() {
		return studentID;
	}

	/**
	 * Getter:
	 * @return type of programme the student takes part in as a String.
	 */
	public String getDegreeProgramme() {
		return degreeProgramme;
	}	

	/**
	 * Setter:
	 * @param name set the student's name (first name + surname together as a string)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter:
	 * @param gender set the student's gender as a string
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Setter:
	 * @param studentID set the student's ID as a string
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	/**
	 * Setter:
	 * @param degreeProgramme set the student's degree programme as a string
	 */
	public void setDegreeProgramme(String degreeProgramme) {
		this.degreeProgramme = degreeProgramme;
	}

	// toString used to provide a template to format output.
	@Override
	public String toString() {
		return "[" + name + ", " + gender + ", " + "ID: " + studentID + ", " + degreeProgramme + "]";
	}

	/**
	 * Method used to check if there are two or more objects with the same values
	 * @param object is used to invoke any object's any value
	 * @return type boolean: true if an object's values equal another object's values.
	 */
	public boolean 
	equals(Student object) {
		if (name.equals(object.getName()) && gender.equals(object.getGender()) && 
				studentID.equals(object.getStudentID()) && degreeProgramme.equals(object.getDegreeProgramme())){
			return true;
		}
		else
			return false;
	}

	// Beginning of output:
	public static void main(String[] args) {

		// Creating a new instance for John Smith providing all the necessary data in order, as Strings:
		Student s1 = new Student ("John Smith", "male", "1111111", "ICY");

		// Creating a new instance for Jane Doe providing all the necessary data in order, as Strings:
		Student s2 = new Student ("Jane Doe", "female", "2222222", "MSC");

		// Creating a new instance for Jane Doe providing all the necessary data in order, as Strings:
		Student s3 = new Student ("Jane Doe", "female", "2222222", "MSC");

		// Output of John Smith's data:
		System.out.println(s1);

		// Output of John Smith's data:
		System.out.println(s2);		

		// Output of John Smith's data:
		System.out.println(s3);
	}
}
package Exercise1;

/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16 Software Workshop
 *         Worksheet 4: Exercise 1: Part (a)
 *         The program creates the generic environment from which exam questions may be created
 *         by further specifying types of questions in other classes. The current class creates
 *         a generic question object and contains the necessary getter & setter methods.
 */
public class ExamQuestion {

	private String question;
	private int maximalMark;

	/**
	 * CONSTRUCTOR to create generic question objects which are 
	 * to be further speficied by other classes
	 * @param question exam question 
	 * @param maximalMark maximum mark
	 */
	public ExamQuestion(String question, int maximalMark) {
		super();
		this.question = question;
		this.maximalMark = maximalMark;
	}

	/**
	 * GETTER FOR QUESTION
	 * @return question as a String
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * SETTER FOR QUESTION
	 * @param question is set for the object
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * GETTER FOR MAXIMALMARK
	 * @return maximalMark as an Int
	 */
	public int getMaximalMark() {
		return maximalMark;
	}

	/**
	 * SETTER FOR MAXIMALMARK
	 * @param maximalMark is set for the object
	 */
	public void setMaximalMark(int maximalMark) {
		this.maximalMark = maximalMark;
	}

	/**
	 * TOSTRING METHOD
	 * to format Questions & Maximum mark values
	 */
	public String toString() {
		return "Question (Maximal mark: " + maximalMark + ")\n"
				+ question + "\n";
	}
	
	// LOCAL TESTING 
	public static void main(String[] args) {
		
		// TESTING EXAMQUESTION CONSTRUCTOR
		ExamQuestion eq1 = new ExamQuestion("2+3=?", 4);

		// TESTING TOSTRING METHOD
		System.out.println(eq1.toString());
	}
}

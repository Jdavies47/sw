package Exercise1;

/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16 Software Workshop
 *         Worksheet 4: Exercise 1: Part (c)
 *         The current class can be used to create simple maths-problem questions using the ExamQuestion superclass
 *         which contains the most generic information of the question objects created, further specified by the current
 *         class. The correct answer to the simple arithmetic question is stored in a separate variable, which is 
 *         compared to the user-entered answer. Upon providing the right answer the maximum amount of marks are rewarded, 
 *         otherwise zero.
 */
public class ExamQuestionNumeric extends ExamQuestion {

	/**
	 * VARIABLE
	 * correctAnswer to store the correct answer as an int
	 */
	private int correctAnswer;

	/**
	 * CONSTRUCTOR:
	 * to create simple arithmetic question objects to which the user is supposed to provide answers as numbers
	 * @param question the question as a String
	 * @param maximalMark the maximum amount of marks stored as an int to be given if the correct answer is given
	 * @param correctAnswer the correct answer, which if given, is rewarded by the maximal mark
	 */
	public ExamQuestionNumeric(String question, int maximalMark, int correctAnswer) {
		super(question, maximalMark);
		this.correctAnswer = correctAnswer;
	}

	/**
	 * METHOD
	 * @param value compared to correctAnswer's value
	 * @return then returns either maximalMark if the answer is correct,
	 * or zero, if it isn't.
	 */
	public int answer(int value) {
		if (value == correctAnswer) {
			return getMaximalMark();
		} else
			return 0;
	}

	@Override
	/**
	 * TOSTRING METHOD
	 * to format Questions & Maximum mark values
	 */
	public String toString() {
		return "Question (Maximal mark: " + ExamQuestionNumeric.this.getMaximalMark() + ")\n"
				+ ExamQuestionNumeric.this.getQuestion() + "\n" + "Correct answer is: " + correctAnswer + "\n";
	}

	// LOCAL TESTING
	public static void main(String[] args) {
		
		// TESTING CONSTRUCTOR LOCALLY
		ExamQuestionNumeric q2 = new ExamQuestionNumeric("2+3 = ?", 10, 5);

//		 TESTING ANSWER(INT VALUE) LOCALLY
		System.out.println("Correct answer! " + q2.answer(5) + " points.");
		System.out.println("Incorrect answer! " + q2.answer(6) + " points.");
		
		// TESTING TOSTRING FORMATTING LOCALLY
		System.out.println(q2.toString());
	}
}

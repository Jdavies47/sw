package Exercise1;

/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16 Software Workshop
 *         Worksheet 4: Exercise 1: Part (b)
 *         The current class can be used to create multiple-choice style questions using the ExamQuestion superclass
 *         which contains the most generic information of the question objects created, further specified by the current
 *         class. A list of possible answers is created to which the user can add any number of possible answers.
 *         On creating an object the correct answer is also marked by storing its ordinal number in a separate variable
 *         which is compared to the user-entered answer to check its correctness. Upon providing the right answer the maximum amount of marks are rewarded, 
 *         otherwise zero.
 */
import java.util.ArrayList;

public class ExamQuestionSimpleChoice extends ExamQuestion {

	/**
	 * VARIABLES
	 * ArrayList<String> possibleAnswers to store all possible answers out of which the user has to choose one by calling its 
	 * ordinal number
	 * int correctAnswer to store the ordinal number to the correct answer that is stored in the ArrayList
	 */
	private ArrayList<String> possibleAnswers = new ArrayList<>();
	private int correctAnswer;
	
	/**
	 * CONSTRUCTOR to create multiple-choice exam question objects
	 * @param question the question as a String
	 * @param maximalMark the maximum amount of marks stored as an int to be given if the correct answer is given
	 * @param possibleAnswers the list of possible answers as an ArrayList<String>, out of which only one is correct
	 * @param correctAnswer number value of the ordinal number of the correct answer stored as an int
	 */
	public ExamQuestionSimpleChoice(String question, int maximalMark, ArrayList<String> possibleAnswers, int correctAnswer) {
		super(question, maximalMark);
		
		this.possibleAnswers = possibleAnswers;
		this.correctAnswer = correctAnswer;
	}

	/**
	 * METHOD
	 * @param value compared to correctAnswer's value
	 * @return then returns either maximalMark if the answer is correct,
	 * or zero, if it isn't.
	 */
	public int answer(int value){
		if(value == correctAnswer){
			return getMaximalMark();
		}
		else
		return 0;
	}
	
	
	/* 
	 * TOSTRING METHOD
	 * to format Questions, Maximal marks, possible answers & correct answers output
	 */
	@Override
	public String toString() {
		return "Question (Maximal mark: " + getMaximalMark() + ")\n" + getQuestion() + "\n"
				+ "Possible answers are: " + possibleAnswers.toString().replace(",", "\n").replace("[", "").replace("]", "\n").replace(" ", "")
						+ "Correct answer position is: " + correctAnswer + "\n";
	}

	// LOCAL TESTING
	public static void main(String[] args) {
		
		// TESING ARRAYLST FUNCTIONS LOCALLY
		ArrayList<String> a = new ArrayList<>();
		a.add("4");
		a.add("5");
		a.add("10");
		a.add("20");
		
		// TESTING CONSTRUCTOR LOCALLY
		ExamQuestionSimpleChoice q1 = new ExamQuestionSimpleChoice("2+3 = ?", 10, a, 2);
		
		// TESTING ANSWER(INT VALUE) LOCALLY
		System.out.println("Correct answer! " + q1.answer(2) + " points.");
		System.out.println("Incorrect answer! " + q1.answer(3) + " points.");
		
		// TESTING TOSTRING METHOD LOCALLY
		System.out.println(q1.toString());
	}
}

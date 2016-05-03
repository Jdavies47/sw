package tryingHarder;

public class AssessedExercise extends Exercise{
	
	private int maximalMarks;
	
	public AssessedExercise(String difficulty, String text, int maximalMarks) {
		super(difficulty, text);
		this.maximalMarks = maximalMarks;
	}
	
	@Override
	public String toString(){
		return super.toString() + ". Maximal marks: " + maximalMarks;
	}
	
	public static void main(String[] args) {
		AssessedExercise a = new AssessedExercise("easy", "1+1=?", 100);
		System.out.println(a);
	}

}

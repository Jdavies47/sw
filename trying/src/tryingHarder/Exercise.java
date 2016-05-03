package tryingHarder;

public class Exercise {
	private String difficulty;
	private String text;

	public Exercise(String difficulty, String text) {
		this.difficulty = difficulty;
		this.text = text;
	}

	/**
	 * @return the difficulty
	 */
	public String getDifficulty() {
		return difficulty;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	public String toString() {
		return String.format("Exercise (%s):\n%s", getDifficulty(), getText());
	}
}

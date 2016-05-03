public class Measure {

	/**
	 * VARIABLES
	 */
	private String description;
	private int value;
	
	/**
	 * CONSTRUCTOR
	 */
	Measure(String description, int value){
		this.description = description;
		this.value = value;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	
	
}

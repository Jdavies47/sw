package tryingHarder;

public class Food {
	private String protein;
	public String carbs;
	
	Food(String protein, String carbs){
		this.protein = protein;
		this.carbs = carbs;
	}
	
	public String toString(){
		return this.protein + " " + this.carbs;
	}
}

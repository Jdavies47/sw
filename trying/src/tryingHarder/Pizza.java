package tryingHarder;

public class Pizza extends Food {
	private String protein = "whatever";
	
	Pizza(String protein, String carbs){
		super(carbs,protein);
	}
	
	public String toString(){
		return this.carbs + " " + this.protein;
	}


	public static void main(String[] args) {
		Food dinner = new Food ("eggs", "sugar");
		System.out.println(dinner);
		
		Pizza pepperoni = new Pizza("pepperoni","dough");
		System.out.println(pepperoni);
		
		Food lunch = new Pizza("cheese","dough");
		System.out.println(lunch);
		
//		Pizza diavola = new Food("salami","dough");
//		System.out.println(diavola);
	}
}

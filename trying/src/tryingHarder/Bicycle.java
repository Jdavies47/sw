package tryingHarder;

public class Bicycle extends Vehicle{
	
	private int numberOfWheels = 2;
	
	public Bicycle(double speed, double weight){
		super(speed, weight, 1);
	}
	
	@Override
	public String toString(){
		return super.toString() + " It has "+
	numberOfWheels + " wheels.";
	}
	
	public static void main(String[] args) {
		Bicycle b = new Bicycle(40, 18);
		System.out.println(b);
	}
}
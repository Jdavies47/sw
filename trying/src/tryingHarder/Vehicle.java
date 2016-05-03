package tryingHarder;

public class Vehicle {
	
	private double speed, weight;
	private int numberOfPeople;

	public Vehicle(double speed, double weight, int numberOfPeople) {
		this.speed = speed;
		this.weight = weight;
		this.numberOfPeople = numberOfPeople;
	}

	public String toString() {
		return "The vehicle has a max speed of " + this.speed + " km/h,\n" + "a weight of " + this.weight + " kg, and "
				+ "can carry " + this.numberOfPeople + " person(s).";
	}
}

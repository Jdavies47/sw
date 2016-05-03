package LabLecture;

public class Temperature {
	
	private double celsius, fahrenheit;
	
	public Temperature(double celsius){
		this.celsius = celsius;
		this.fahrenheit = 1.8 * celsius + 32;
	}
	
	
	/**
	 * @return the celsius
	 */
	public double getCelsius() {
		return celsius;
	}


	/**
	 * @param celsius the celsius to set
	 */
	public void setCelsius(double celsius) {
		this.celsius = celsius;
		this.fahrenheit = 1.8 * celsius + 32;
	}


	/**
	 * @return the fahrenheit
	 */
	public double getFahrenheit() {
		return fahrenheit;
	}


	/**
	 * @param fahrenheit the fahrenheit to set
	 */
	public void setFahrenheit(double fahrenheit) {
		this.fahrenheit = fahrenheit;
		this.celsius = (fahrenheit-32) / 1.8;
	}

	
	@Override
	public String toString() {
		return celsius + "C corr.to " + fahrenheit + "F.";
	}


	public static void main(String[] args){
		Temperature t1 = new Temperature(20);
		Temperature t2 = new Temperature(0);
		System.out.println(t1);
		System.out.println(t2);
		
	}
}

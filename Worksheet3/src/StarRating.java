/**
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 3: Exercise 1
 * 
 * The program interprets star-ratings (0.0 - 5.0) to return values "not rated", "crap", "OK" or "has only one review".
 * Two methods are included:
 * 1.) interpret interprets values entered in .5 increments.
 * 2.) interpretRange interprets any rational number value.
 */
public class StarRating {
	// variables
	static double rating;
	
	// constructor
	public StarRating(double rating) {
		super();
		StarRating.rating = rating;
	}

	/**
	 * getter used to retrieve rating value
	 * @return rating returned
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * setter used to set rating value
	 * @param rating
	 */
	public void setRating(double rating) {
		StarRating.rating = rating;
	}
	
	/**
	 * First interpret methood takes in a double variable 'rating' entered in .5 increments and returns interpretation
	 * @param rating entered in .5 increments
	 * @return interpretation ranging from "not rated", "crap", "OK" or "has only one review"
	 */
	public static String interpret(double rating){
		if ( rating == 0.0 ){		// if the rating entered is 0.0, the value "not rated" is returned
			return "not rated";
		}
		else if( rating == 0.5 || // if the rating entered is 0.5, 1.0, 1.5, 2.0, 2.5, 3.0 or 3.5,
				rating == 1.0 ||   // the value "crap" is returned
				rating == 1.5 || 
				rating == 2.0 || 
				rating == 2.5 || 
				rating == 3.0 || 
				rating == 3.5) {
			return "crap";
		}
		else if (rating == 4.0){	// if the rating entered is 4.0, the value "OK" is returned.
			return "OK";
		}
		else if (rating == 4.5){	// if the rating entered is 4.5, the value "excellent" is returned
			return "excellent";
		}
		else if (rating == 5.0){	// if the rating entered is 5.0, the value "[has only one review]" is returned
			return "[has only one review]";		
		}
		else
			return "not rated";		// if the rating entered is anything else, the value "not rated" is returned
	}

	/**
	 * Second interpret method takes in a rational number as a double variable and returns interpretation
	 * @param rating entered as any rational number
	 * @return interpretation ranging from "not rated", "crap", "OK" or "has only one review"
	 */
	public static String interpretRange(double rating){		

		if (rating >= 0.0){									// interpretation only performed if the value is equal to or greater than 0.0

			if (rating >= 0.0 && rating < 4.0) {			// if the value is smaller than 4.0 but equal to or greater than 0.0, the value "crap" is returned
				System.out.println("crap");
				return "crap";
			}
			else if (rating >= 4.0 && rating < 4.5) {		// if the value is equal to or greater than 4.0, but smaller than 4.5, the value "OK" is returned
				System.out.println("OK");
				return "OK";
			}
			else if (rating >= 4.5 && rating < 5.0) {		// if the value is equal to or greater than 4.5, but smaller than 5.0, the value "excellent" is returned
				System.out.println("excellent");
				return "excellent";
			}
			else {
				System.out.println("[has only one review]");// if the value is equal to or greater than 5.0, the value "[has only one review]" is returned
				return "[has only one review]";	
			}

		}
		else {
			System.out.println("not rated");

			return "not rated";		// in any other case, the value "not rated" is returned
		}
	}
	public static void main(String[] args) {
		interpret(4.0);
	}
}

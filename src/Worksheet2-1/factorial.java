public class factorial{
	public static int factorial(int n){
		return (n==1)?1:
		n*factorial(n-1);
	}
		public static void main(String[] args){
		System.out.println("5! = " + factorial(5));
		}
}
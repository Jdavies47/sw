package Ex11;

public class loop {
	public static int f(int x) {
		if (x == 0 || x == 1) {
			return 1;
		} else {
			return f(x - 1) + f(x - 2);
		}
	}

	public static void main(String[] args) {
		System.out.println(f(5));
	}
}

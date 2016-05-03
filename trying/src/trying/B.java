package trying;

public class B extends A {
	private String a;

	B(String a, String b) {
		super(b, a);
	}

	public String toString() {
		return this.b + " a: " + this.a + 
				" \nThis is a B object.\n";
	}

	public static void main(String[] args) {
		A first = new A("1", "2");
		System.out.println(first);

		B second = new B("1", "2");
		System.out.println(second);

		A third = new B("1", "2");
		System.out.println(third);

		// B fourth = new A("1","2");
		// System.out.println(fourth);
	}
}

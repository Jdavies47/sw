package trying;

public class A {
	private String a;
	public String b;

	A(String a, String b) {
		this.a = a;
		this.b = b;
	}

	public String toString() {
		return this.a + " b: " + this.b + 
				" \nThis is an A object.\n";
	}
}

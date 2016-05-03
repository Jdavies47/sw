// This example illustrates deadlock.

public class Eat {

    public static void main(String [] args) {
	Cutlery c = new Cutlery();

	Eater1 e1 = new Eater1(c);
	Eater2 e2 = new Eater2(c);

	e1.start();
	e2.start();
    }
}

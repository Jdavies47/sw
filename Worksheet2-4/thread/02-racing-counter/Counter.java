public class Counter {

    private int c = 0;
    
    public void increment() {
	c++;   // compiled as    
	       //       load c into cpu register r
               //       increment r
               //       store r into c
    }

    public void decrement() {
	c--;   // compiled as    
	       //       load c into cpu register r
               //       decrement register r
               //       store r into c
    }

    public int get() {
	return c;
    }
}

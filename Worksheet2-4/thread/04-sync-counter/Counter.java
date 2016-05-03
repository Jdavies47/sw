public class Counter {

    private int c = 0;
    
    public synchronized void increment() {
	c++;   // compiled as    
	       //       wait until lock available
	       //       load c into cpu register r
               //       increment r
               //       store r into c
	       //       release lock
    }

    public synchronized void decrement() {
	c--;   // compiled as    
	       //       wait until lock available
	       //       load c into cpu register r
               //       decrement register r
               //       store r into c
	       //       release lock
    }

    public synchronized int get() {
	return c;
    }
}

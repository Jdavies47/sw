// Is this good?
public class Counter {

    private int c = 0;
    
    private Object inc_lock = new Object();
    private Object dec_lock = new Object();

    public void increment() {
	synchronized(inc_lock) { 
             c++; 
        }
    }

    public synchronized void decrement() {
 	synchronized(dec_lock) { 
             c--; 
        }
    }

    public synchronized int get() {
	return c;
    }
}

public class Slave implements Runnable {
    // Notice that we implement Slave as a Runnable object instead of
    // as a Thread.   We leave it to the Master to make a Thread out
    // of it.

    private String name;
    private Counter counter;
 
    public Slave (String name, Counter counter) {
        this.name = name;
        this.counter = counter; 
    }

    private void tell(String message) {
        System.out.println(message);
    }

    public void run () {
	tell("Slave " + name + " got started");

	for (int i = 0; i < 1000000; i++) {
	    synchronized (counter) {
		 counter.increment();
            }

	    synchronized (counter) {
		counter.decrement();
	    }
	}

	tell("Slave " + name + " finished");
    }
}


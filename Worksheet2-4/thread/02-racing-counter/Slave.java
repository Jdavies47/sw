import java.util.*;

public class Slave extends Thread {

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
	    counter.increment();
	    counter.decrement();
	}

	tell("Slave " + name + " finished");
    }
}


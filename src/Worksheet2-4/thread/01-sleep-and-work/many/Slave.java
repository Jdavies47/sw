import java.util.*;

public class Slave extends Thread {

    /*
     * A class to create a sample Slave thread, that repeatedly sleeps
     * for a random amount of time, while printing a message
     * indicating that it is doing so.  If uninterrupted, it goes on
     * forever.  Note the infinite loop!
     * If interrupted, it stops.
     */

    private String name;
 
    public Slave (String name) {
        this.name = name; 
    }

    private void tell(String message) {
        System.out.println(message);
    }

    public void run () {
        Random r = new Random();

        try {
	    int i = 0;

            while (true) {
                int n = r.nextInt(2000);

		i = i + 1;

                tell(name + " has counted " + i +
                     " and now will sleep for " + n + "ms");

                sleep(n);
            }
        }
        catch (InterruptedException e) {
            tell(name + " has been interrupted and hence decided to end");
            // (But other decisions are possible.)
        }
    }
}


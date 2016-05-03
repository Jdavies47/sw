// Usage:
//        java Master

public class Master {
    // We don't need a constructor.

    /* 
     * This simple program creates two "Slave" threads called John and
     * Mary and sleeps for 5 seconds.  After waking up, it kills both
     * the threads and finishes.  Each Slave thread repeatedly sleeps
     * for a random amount of tiem, simulating the idea that it is
     * doing some work for an unknown amount of time.
     */

    private static void tell(String message) {
        System.out.println(message);
    }

    public static void main (String args[]) {
        tell("Master got started");

        tell("Master is starting slave John");
        Slave john = new Slave ("John");
        john.start();

        tell("Master is starting slave Mary");
        Slave mary = new Slave ("Mary");
        mary.start();
        
        int n = 5;

        tell("Master will sleep for " + n + " seconds");

        try {
            Thread.sleep(n * 1000); 
            tell("Master has woken up");
        }
        catch (InterruptedException e) {
            tell("Somebody has awaken the Master" + e);
            // This won't actually happen.
        }
        finally {
            john.interrupt();
            mary.interrupt();
	}

	tell("Master ended");
        }
}

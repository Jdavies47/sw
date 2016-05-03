// Usage:
//        java Master name1 name2 name3 ...

public class Master {
    // We don't need a constructor.

    /* 
     * This simple program creates several "Slave" threads name1,
     * name2 etc. and sleeps for 5 seconds.  After waking up, it kills
     * all the threads and finishes.  Each Slave thread repeatedly sleeps
     * for a random amount of tiem, simulating the idea that it is
     * doing some work for an unknown amount of time.
     */

    private static void tell(String message) {
        System.out.println(message);
    }

    public static void main (String args[]) {
        tell("Master got started");

        Slave [] slave = new Slave [args.length];

        for (int i = 0; i < args.length; i++) {
            tell("Master is starting slave " + args[i]);
            slave[i] = new Slave(args[i]);
            slave[i].start();
        }

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
            for (int i = 0; i < slave.length; i++) {
                slave[i].interrupt();
            }
        }
	
        tell("Master ended");
    }
}

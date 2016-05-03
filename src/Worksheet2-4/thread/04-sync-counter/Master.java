// Usage:
//        java Master name1 name2 name3 ...
//
// In this version, we annotate the methods of the Counter objects as
// being synchronized.  This has the same effect as wrapping the
// method calls in synchronized statements.

public class Master {

    private static void tell(String message) {
        System.out.println(message);
    }

    public static void main(String args[]) {
        tell("Master got started");

        Counter counter = new Counter();

        Thread [] slave = new Thread[args.length];

        for (int i = 0; i < args.length; i++) {
            tell("Master is starting slave " + args[i]);
            slave[i] = new Thread(new Slave(args[i],counter));
            slave[i].start();
        }

        tell("Master will now wait for each slave to finish");

        try {
            for (Thread s : slave)
                s.join();
	}
        catch (InterruptedException e) {
            tell("Interruption before completion of the joins" + e);
            tell("Master has given up waiting for slaves");
        }

	tell("counter should be 0 and actually is " + counter.get());
	    
        tell("Master is exiting");
    }
}

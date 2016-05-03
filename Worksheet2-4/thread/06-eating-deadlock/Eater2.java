public class Eater2 extends Thread {
    private Cutlery cutlery;

    public Eater2 (Cutlery cutlery) {
	this.cutlery = cutlery;
    }

    private void tell(String s) {
	System.out.println(s);
    }

    public void run () {
	for (int i = 0; true; i++) {

	    synchronized (cutlery.getKnife()) {

		synchronized (cutlery.getFork()) {
		    tell("Person 2 has eaten " + i + " times ");

		}
	    }

            if (i % 10000 == 0)
		try {
		    tell("Person 2 will now eat for 1ms");
		    sleep(1);
		}
		catch (InterruptedException e) {
		    tell("Person 2 has finished eating");
		}
	}
    }
}

public class Eater1 extends Thread {
    private Cutlery cutlery;

    public Eater1 (Cutlery cutlery) {
	this.cutlery = cutlery;
    }

    private void tell(String s) {
	System.out.println(s);
    }

    public void run () {
	for (int i = 0; true; i++) {

	    synchronized (cutlery.getFork()) {

		synchronized (cutlery.getKnife()) {
		    tell("Person 1 has eaten " + i + " times ");

		}
	    }

            if (i % 10000 == 0)
		try {
		    tell("Person 1 will now eat for 1ms");
		    sleep(1);
		}
		catch (InterruptedException e) {
		    tell("Person 1 has finished eating");
		}
	}
    }
}

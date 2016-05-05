import javax.swing.*;
import java.awt.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Zsolt Pazmandy on 04/05/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */
public class SwingUIAndThreadsPractice {

    /**
     * Given below is the skeleton for a simple JPanel class displaying a counter.
     * <p>
     * The button labelled “Up” is meant to increase the value of the counter displayed by 1
     * and the button labelled “Down” is meant to decrease it by 1. However, the buttons do
     * not yet have any actions defined.
     * <p>
     * • Define actions for the button objects using inner classes, and
     * • define the method setButtonActions to link the actions to buttons.
     */

    public static class CounterPanel extends JPanel {
        int count = 0;
        JTextField countDisplay = new JTextField("       0");
        JButton upButton = new JButton("Up");
        JButton downButton = new JButton("Down");

        public CounterPanel() {
            setPreferredSize(new Dimension(300, 100));
            add(countDisplay);
            add(upButton);
            add(downButton);
            setButtonActions();
        }

        public void setButtonActions() {

            upButton.addActionListener(e -> {
                count++;
                countDisplay.setText("" + count);
            });

            downButton.addActionListener(e -> {
                        count--;
                        countDisplay.setText("" + count);
                    }
            );
        }
    }

    /**
     * (b) Explain the role of the start method, mentioning parallel threads. [3%]
     * <p>
     * the start() method initiates the Thread. Since there are two in the
     * application below, the method has to be called on both instances of the
     * class. Calling the starter method is how the sequence of the threads
     * can be programmed and arranged.
     * <p>
     * (c) Explain the role of the synchronized statement, mentioning locks. [3%]
     * <p>
     * the run method is implemented in a way that first toolA, then toolB is
     * synchronised i.e. reserved for exclusive use for only the object that
     * has called the method. e.g. If worker1 accesses toolA first, worker2
     * cannot access it as long as worker1 hasn't finished.
     * <p>
     * (d) The program may deadlock. Explain why, giving an example situation. [3%]
     * <p>
     * A deadlock is when one thread tries to access the object that is being
     * reserved for use by another thread which is also "placed on hold"
     * waiting for the object that is reserved by the first thread.
     * Basically both threads wait for the object that they cannot access as
     * it is reserved by the other thread, and neither of the two can proceed.
     * If this happens, the program halts. I
     */

    public static class Worker extends Thread {

        int counter = 0;

        Object toolA;
        Object toolB;

        String nameA;
        String nameB;

        ReentrantLock lock = new ReentrantLock();


        public Worker(Object toolA, Object toolB, String nameA, String nameB) {
            this.toolA = toolA;
            this.toolB = toolB;
            this.nameA = nameA;
            this.nameB = nameB;
        }


        private void pretendWork() throws InterruptedException {

            counter++;
            System.out.println(this.getName() + " working with " + this.nameA + " & " + this.nameB + " counter: " + counter);
            sleep(1);
        }


        public void run() {


            while (true) {
                try {
//                    if (lock.tryLock(1, TimeUnit.SECONDS)) {
                        pretendWork();
//                    } else {
//                        sleep(500);
//                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

//                    synchronized (toolA) {
//                        synchronized (toolB) {
//                    pretendWork();
//                        }
//                    }
//                }

    }


    public static void main(String[] args) {
        Object hammer = new Object();
        Object screwDriver = new Object();
        Worker worker1 = new Worker(hammer, screwDriver, "hammer", "screwdriver");
        Worker worker2 = new Worker(screwDriver, hammer, "screwdriver", "hammer");
        Worker worker3 = new Worker(screwDriver, hammer, "screwdriver", "hammer");
        Worker worker4 = new Worker(screwDriver, hammer, "screwdriver", "hammer");
        Worker worker5 = new Worker(screwDriver, hammer, "screwdriver", "hammer");

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();
        worker5.start();
    }
}
}

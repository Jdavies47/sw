import java.util.ArrayList;

/**
 * Created by Zsolt Pazmandy on 17/04/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */
public class AI_HW3_q_learning_algo {
    public static void main(String[] args) {

        int i = 0;
        double l, u, r, d;

        ArrayList<Double> utility = new ArrayList<>();
        ArrayList<String> max = new ArrayList<>();

        utility.add(0.0);
        max.add("");

        double precision = 1.0;

        while (precision > 0.01) {

            l = -4 + 0.9 * (0.75 * utility.get(i) - 25);
            u = -4 + 0.9 * (0.75 * utility.get(i) + 25);
            r = -4 + 0.9 * (0.25 * utility.get(i) + 25);
            d = -4 + 0.9 * (0.25 * utility.get(i) - 25);

            utility.add(Math.max(Math.max(l, u), Math.max(r, d)));

            i++;
            precision = utility.get(i) - utility.get(i - 1);

            if (utility.get(i) == l) {
                max.add("Left");
            } else if (utility.get(i) == u) {
                max.add("Up");
            } else if (utility.get(i) == r) {
                max.add("Right");
            } else if (utility.get(i) == d) {
                max.add("Down");
            }

            if (i < 10) {
                System.out.print(" ");
            }

            System.out.print("i: " + i);
            System.out.printf("|Q(L,P) = " + "%.4f", l);
            System.out.printf("|Q(U,P) = " + "%.4f", u);
            System.out.printf("|Q(R,P) = " + "%.4f", r);
            System.out.printf("|Q(D,P) = " + "%.4f", d);
            System.out.printf("|p(π): " + "Q(" + max.get(i));
            System.out.printf(" = " + "%.4f" + ")\n", utility.get(i));

        }
    }
}


/**
 * Created by Zsolt Pazmandy on 08/04/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */
public class AI_homework3_algo {
        public static void main(String[] args) {
            int pizza = 10;
            int chips = 5;
            double chosen = 0.8;
            double notChosen = 0.2;
            double r; // U(Right|home)
            double l; // U(Left|home)
            double d; // Discount factor

            for (d = 0.9; d > 0.1; d = d - 0.1) {
                r = chosen*d*d*d*d*pizza+notChosen*d*d*d*chips;
                System.out.printf("Discount:"+"%.1f"+" | U(Home,Right) " +
                        "%.4f"+"\n", d, r);
                l = notChosen*d*d*d*d*pizza+chosen*d*d*d*chips;
                System.out.printf("Discount:"+"%.1f"+" | U(Home,Left) = " +
                        "%.4f"+"\n\n", d, l);
            }
        }
    }




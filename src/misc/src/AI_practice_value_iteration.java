import java.util.ArrayList;

/**
 * Created by Zsolt Pazmandy on 13/05/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */
public class AI_practice_value_iteration {
    public static void main(String[] args) {

        int i = 0;
        double movingFromA, stayingAtA, movingFromB, stayingAtB;

        ArrayList<Double> utility = new ArrayList<>();
        ArrayList<String> max = new ArrayList<>();

        double success = 0.8;
        double fail = 0.2;

        double gamma = 0.5;

        double rewardA = -1;
        double rewardB = 10;

        utility.add(Math.max(rewardA, rewardB));

        max.add("");

        double precision = 1.0;

        while (precision > 0.01) {

            movingFromA = rewardA + (gamma * (success * utility.get(i) + fail * rewardA));
            movingFromB = rewardB + (gamma * (success * utility.get(i) + fail * rewardB));
            stayingAtA = rewardA + (gamma * (success * utility.get(i) + fail * rewardA));
            stayingAtB = rewardB + (gamma * (success * utility.get(i) + fail * rewardA));


            utility.add(Math.max(Math.max(movingFromA, movingFromB),Math.max(stayingAtA, stayingAtB)));

            i++;
            precision = utility.get(i) - utility.get(i - 1);

        }
        System.out.println(utility.get(i));
    }
}

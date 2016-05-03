/**
 * Created by Zsolt Pazmandy on 11/04/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */
public class better_sorting_algo_test {
    public static void main(String[] args) {
        int c[] = {20, 18, 5, 2, 8, 3, 7, 6, 11, 29, 24, 30, 25};
//        int c[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};


        int lo = 0;
        int hi = c.length;
        int counter = 0;

        for(int i : c) {
            System.out.print(i + ",");
        }

        while (c[lo] != c[hi - 1]) {

            counter++;

            if (c[lo] % 2 == 0) {

                lo++;
                System.out.println(" | " + counter + ". step: left bar:" + c[lo] + " & right bar: " + c[hi-1]);
                for(int i : c)
                    System.out.print(i + ",");

            } else if (c[hi - 1] % 2 != 0) {

                hi--;
                System.out.println(" | " + counter + ". step: left bar:" + c[lo] + " & right bar: " + c[hi-1]);
                for(int i : c)
                    System.out.print(i + ",");

            } else {

                int temp = c[hi - 1];
                c[hi - 1] = c[lo];
                c[lo] = temp;
                System.out.println(" | " + counter + ". step: " + c[lo] + " has been swapped with: " + c[hi-1]);
                for(int i : c)
                    System.out.print(i + ",");

            }

        }



    }
}

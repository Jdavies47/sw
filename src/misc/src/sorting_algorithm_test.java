/**
 * Created by Zsolt Pazmandy on 01/04/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */
public class sorting_algorithm_test {

    public static void main(String[] args) {

        int c[] = {20, 18, 5, 2, 8, 3, 7, 6, 11, 29, 24, 30, 25};
//        int c[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        int lo = 0;
        int hi = c.length;
        int count = 0;

        while (lo < hi) {
            count++;
            System.out.println(count+"| lo:"+lo+"|hi:"+hi);

            if (c[lo] % 2 != 0) {

                int temp = c[lo];
                c[lo] = c[hi - 1];
                c[hi - 1] = temp;
                hi--;

            } else {
                lo++; 
           }
        }
    }
}

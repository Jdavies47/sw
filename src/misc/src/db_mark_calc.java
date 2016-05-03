import java.util.Scanner;

/**
 * Created by Zsolt Pazmandy on 11/04/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */
public class db_mark_calc {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int ca1 = 83;
        int ca2 = 78;
        int exam;
        System.out.print("enter exam results: ");
        exam = Integer.parseInt(in.nextLine());
        System.out.println("final results: " + (ca1*0.1+ca2*0.1+exam*0.8));
    }



}

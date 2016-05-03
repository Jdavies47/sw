/**
 * Created by Zsolt Pazmandy on 27/04/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */
public class WhatFibo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE: \n'WhatFibo + n'\nwhere n is the ordinal number of the fibonacci number you're " +
                    "looking for");
        } else {
            int n = Integer.parseInt(args[0]);
            System.out.print("The " + n + "th fibonacci number is: ");
            System.out.printf("%.0f.", (Math.pow(1.0 + Math.sqrt(5.0), n) - (Math.pow(1.0 - Math.sqrt(5.0), n))) /
                    (Math.pow(2.0, n) * Math.sqrt(5.0)));
        }

    }
}

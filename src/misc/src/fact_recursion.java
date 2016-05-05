/**
 * Created by Zsolt Pazmandy on 12/04/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */

class fact_recursion {






    static int factorial(int number) {
        return number == 0 ? 1 : number * factorial(number - 1);
    }

    /*

    5! = 5 * 4!

    4! = 4 * 3!

    3! = 3 * 2!

    2! = 2 * 1!

    1! = 1 * 0!

    0! = 1

    Then we can complete previous operations we didn't know at
    the time. So,

    1! = 1 * 1

    2! = 2 * 1

    3! = 3 * 2 * 1

    4! = 4 * 3 * 2 * 1

    5! = 5 * 4 * 3 * 2 * 1

    return: 5 * 4 * 3 * 2 * 1 = 120

     */



    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

}

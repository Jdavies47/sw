/**
 * Created by Zsolt Pazmandy on 01/05/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */
/*
Write a static method arrayMax2(int[][] a) that returns the maximal value of a
two-dimensional array a[n][m] of type int. E.g., for
int[][] a =
{{1, 2, 3},
{4, 5, 6},
{7, 8, 9},
{-1, -2, -3}};
arrayMax2(a) should return 9.
For the empty array int[][] a = {{}}; it should return Integer.MIN_VALUE.
How can you test the correctness of your program?
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                System.out.print("[]");
//                if (max < a[i][j]) {
//                    max = a[i][j];
//                }
//            }
//        }

Let a be a non-empty one-dimensional array of type String.
Write a method averageLength that returns the average length of the strings.
E.g., for String[] a = {"123", "12345"}; the method should return 4 (as average
of 3 and 5).
        String[] a = {"123", "12345"};
        int avg = 0;
        int j = 0;

        for (int i = 0; i < a.length; i++) {
            avg = avg + a[i].toCharArray().length;
            j++;
        }

        avg = (int)avg / j;

        System.out.println(avg);

    (a) Declare a class Module with fields name, semester, credits of
    appropriate types
    together with a constructor, as well a getter and a setter for semester.
    (The full class
    would contain other methods, but these are not of concern here.)
     */

        /*
    (b) A company sells two types of goods, perishable and non-perishable goods. Unlike non-
perishable goods, perishable goods have the field bestBeforeDate in addition to the
fields name and price which are common to all goods. Write a corresponding class
structure with constructors and toString() methods. For simplicity assume that dates
are of type String. Make use of inheritance to avoid redundant code.
//     /*public class Goods {
//    String name;
//    int price;
//
//    @Override
//    public String toString() {
//        return "Name of product: " + name + "\n" +
//                "Price of product: " + price + ".\n";
//    }
//}
//
//public class Perishable extends Goods {
//    String bestBeforeDate;
//
//    public Perishable(String name, int price, String bestBeforeDate) {
//        this.name = name;
//        this.price = price;
//        this.bestBeforeDate = bestBeforeDate;
//    }
//
//    @Override
//    public String toString() {
//        return toString() + "Best before date of product: " + bestBeforeDate + "\n";
//    }
//}
//
//public class NonPerishable extends Goods {
//    public NonPerishable(String name, int price) {
//        this.name = name;
//        this.price = price;
//    }
//}*/
public class java_practice {

    /*
                    API Reference:
                class Tree:
            Tree        -- constructor
            Tree        (int a, Tree l, Tree r); -- constructor
            boolean     isEmpty();
            int         getValue();
            Tree        getLeft();
            Tree        getRight();
     */
    /*
    (a) Write a method countNodes() that computes recursively the number of nodes in a
binary tree. You may use the methods in the API at the end of the exam paper.
     */
//public class Tree{
//        public Tree(){
//
//        }
//    }
//    public int countNodes(Tree a) {
//        if (a.getLeft.isEmpty && a.getRight.isEmpty) {
//            return 1;
//        } else {
//            return countNodes(a.getLeft + a.getRight);
//        }
//    }
//
//
}


/**
 * Created by Zsolt Pazmandy on 14/04/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 *
 */
public class binary_search {


    /**
     * Binary Search
     *
     * Result has a property that for every index
     * ( 0 < i <= array.length) & (0 <= a <= array.length)
     * if i < a then arr[i] < x
     * if i >= a then arr[i] >= x
     *
     * requires: arr sorted
     *
     * @param arr array to search
     * @param x value to search for
     * @return number of elements of arr that are < x
     */
    static int search(int[] arr, int x) {

        int l = 0;
        int r = arr.length;

        while (l < r) {                 // loop until l = r-1, meaning when the searchable area has been narrowed
                                        //              down to 1 element = the result = l

            int m = (l + r) / 2;        // l <= m < r

            if (arr[m] < x) {           // if x is in the right half
                l = m + 1;              // the new left bound of the searchable area is m+1
            } else {                    // if x is in the left half
                r = m;                  // the new right bound of the searchable area is m
            }

        }

        return l;
    }


    public static void main(String[] args) {

        int[] a = {1, 3, 6, 12, 21, 23, 25, 26};

        System.out.println(search(a, 23));
        // prints out the number of entries in arr 'a' with values < 23
        // ~ this number is also 23's ordinal number in the array
    }


}

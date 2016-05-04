import java.util.HashSet;

/**
 * Created by Zsolt Pazmandy on 04/05/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */
public class CollectionsPractice {

    /**
     * (a) The following Java method is expected to create and return the set of integers {1, 4, 6}.
     * Fill in the blanks. Use an implementation of sets of your choice.
     * [3%]
     */

    public static HashSet<Integer> mySet() {

        HashSet<Integer> result = new HashSet<>();
        result.add(1);
        result.add(4);
        result.add(6);

        return result;
    }

    /**
     * Given below is a class called Name for names of people (including their last name and
     * first name), and a program to insert two names into a TreeSet of Names.
     * When an attempt is made to run the main method, we encounter an error:
     * Exception in thread "main" java.lang.ClassCastException:
     * Name cannot be cast to java.lang.Comparable
     * • Why does the error arise?
     * • What changes should be made to the Name class to correct the problem?
     */

    /**
    class Name has to implement the Comparable interface
    and specify that it would be able to compare objects
    of the Name class, so the header is:

    public static class Name implements Comparable<Name>

    Implementing the Comparable interface means that the
    class also has to implement AND override the compareTo
    method so that it can compare 2 Name objects:

        1 is the one the compareTo method is called upon
        2 is the one provided by compareTo method's argument

    so the header is:

    @Override
    public int compareTo(Name that)

     */

    public static class Name implements Comparable<Name> {
        public String lastName, firstName;

        public Name(String last, String first) {
            lastName = last;
            firstName = first;
        }

        @Override
        public int compareTo(Name that) {
            return this.firstName.compareTo(that.firstName);
        }
    }

//    public static void main(String[] args) {
//
//        Collection<Name> c = new TreeSet<Name>();
//
//        c.add(new Name("Reddy", "Uday"));
//        c.add(new Name("Kerber", "Manfred"));
//    }







    public static void main(String[] args) {

    }
}

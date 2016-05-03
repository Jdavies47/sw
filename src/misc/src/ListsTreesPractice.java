/**
 * Created by Zsolt Pazmandy on 03/05/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */
public class ListsTreesPractice implements ListInterface, TreeInterface {
    /**
     * Assume a non empty linked list is given. We want to find the position of the maximal
     * element in the list. If there are several maximal elements, then the method should return
     * the first such position. Write a corresponding recursive static method, public static
     * int argMax(List l). (Hint: You may need to write an auxiliary method.)
     * For example, for the linked list with the elements [13, 14, 11, 14, 10, 14], the
     * maximal element is 14 and its first occurrence is at position 1 (we start counting from
     * 0 here), that is, the method should return 1.
     */

    public static int argMax(List l) {
        if (l.getHead() == helper(l)) {
            return 0;
        } else
            return 1 + argMax(l.getTail());
    }

    public static int helper(List l) {
        if (l.isEmpty()) {
            return 0;
        } else
            return Math.max(l.getHead(), helper(l.getTail()));
    }

    /**
     * A weather station measures the temperature every day at 12 noon over a period of
     * time. The results are stored in a linked list of at least two elements. Write a recursive
     * method, public static int biggestConsecutiveDifference(List l), that
     * determines the biggest change in temperature between two consecutive days.
     * For instance, if the following temperatures are measured -11, -21, -15, -10, -8,
     * then the biggest change of two consecutive days is between -11 and -21 as a temperature
     * change of 10 degrees.
     */

    public static int biggestConsecutiveDifference(List l) {
        if (l.getTail().getTail().isEmpty()) {
            return Math.max(l.getHead(), l.getTail().getHead()) - Math.min(l.getHead(), l.getTail().getHead());
        } else {
            return Math.max(l.getHead() - l.getTail().getHead(), biggestConsecutiveDifference(l.getTail()));
        }
    }

    public static int biggestConsecutiveDifferenceJade(List l) {
        if (l.getTail().isEmpty()) {
            return 0;
        }
        return Math.max(Math.abs(l.getHead() - l.getTail().getHead()), biggestConsecutiveDifferenceJade(l.getTail()));
    }

    /**
     * Write a static method, public static int minimalNode(Tree t), that computes
     * recursively the minimal value of a non empty binary tree (of integers). You may use the
     * methods in the API on the next page of the exam paper.
     * Describe in 30-40 words how you would test the correctness of your method?
     */

    public static int minimalNode(Tree t) {
        if (t.getLeft().getEmpty() && t.getRight().getEmpty()) {
            return t.getValue();
        } else if (t.getValue() < minimalNode(t.getLeft()) && t.getValue() < minimalNode(t.getRight())) {
            return t.getValue();
        } else {
            return Math.min(minimalNode(t.getLeft()), minimalNode(t.getRight()));
        }
    }

    public static int minimalNodeJade(Tree t) {
        if (t.getLeft().getEmpty() && t.getRight().getEmpty()) {
            return t.getValue();
        }
        return Math.min(minimalNode(t.getLeft()), minimalNode(t.getRight()));
    }

    /**
     * Consider a function for removing duplicate copies of elements in a sorted list. Static
     * List removeDuplicates (List a) The input list a is required to be sorted in ascending order.
     * The returned list will be again sorted in ascending order, and contain the same elements
     * as a but with no duplicate copies of elements. Decide 5 test cases to test this function.
     * Make sure that all the “boundary cases” are tested. Use a table such as the one below to
     * mention (i) what aspect of the function behaviour you are trying to test, (ii) the input
     * list, and (iii) the expected result or effect.
     */

    public static List removeDuplicates(List l) {
        if (l.isEmpty()) {
            return List.empty();
        } else if (l.getTail().isEmpty()) {
            return l;
        } else if (l.getHead() == l.getTail().getHead()) {
            return removeDuplicates(l.getTail());
        } else {
            return new List(l.getHead(), removeDuplicates(l.getTail()));
        }
    }

    /**
     * Write a method that, given a binary search tree as an argument, produces a list containing
     * its node values in the ascending order. The method declaration should be: static List sortedList(Tree t)
     * If the search tree contains multiple copies of any value, all of them should be retained in
     * the output list.
     */

    public static List sortedList(Tree t) {
        if (t.getEmpty()) {
            return List.empty();
        } else if (t.getLeft().getEmpty() && t.getRight().getEmpty()) {
            return List.cons(t.getValue(), List.empty());
        } else {
            return ListOps.append(sortedList(t.getLeft()), List.cons(t.getValue(), sortedList(t.getRight())));
        }

    }

    public static void main(String[] args) {
        Tree t1 = new Tree(30, new Tree(20, new Tree(15, new Tree(13),
                new Tree(18)), new Tree(25, new Tree(23), new Tree(27,
                new Tree(26), new Tree(28)))), new Tree(50, new Tree(40,
                new Tree(35), new Tree(42)), new Tree(55, new Tree(52),
                new Tree(58))));
        System.out.println(t1);
        System.out.println(sortedList(t1));

    }
}
























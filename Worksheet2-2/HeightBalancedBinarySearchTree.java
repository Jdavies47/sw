/**
 * @author This class contains the solution for Worksheet2
 */
public class HeightBalancedBinarySearchTree implements Worksheet2Interface {
    /**
     * EXERCISE 1
     *
     * @param t
     * @return
     */
    public static Tree negateAll(Tree t) {
        return (t.getEmpty()) ? new Tree() : new Tree(-t.getValue(), negateAll(t.getLeft()), negateAll(t
                .getRight()));
    }

    /**
     * EXERCISE 2
     *
     * @param t
     * @return
     */
    public static Tree mirror(Tree t) {
        return (t.getEmpty()) ? new Tree() : new Tree(t.getValue(), mirror(t.getRight()), mirror(t.getLeft()));
    }

    /**
     * EXERCISE 3
     *
     * @param t
     * @return
     */
    public static List postOrder(Tree t) {
        return (t.getEmpty()) ? List.empty() : ListOps.addToEnd(ListOps.append(postOrder(t.getLeft()),
                postOrder(t.getRight())), t.getValue());
    }

    /**
     * EXERCISE 4
     *
     * @param a
     * @return
     */
    public static boolean allPositive(Tree a) {
        if (a.getEmpty()) {
            return true;
        } else if (a.getValue() >= 0 && allPositive(a.getLeft()) && allPositive(a.getRight())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * EXERCISE 5 Without the construction of lists
     *
     * @param a
     * @return
     */
    public static boolean isSearchTree(Tree a) {
        if (a.getEmpty() ||
                (a.getRight().getEmpty() && a.getLeft().getEmpty() && !a.getEmpty()) ||
                (a.getRight().getEmpty() && !a.getLeft().getEmpty() && !a.getEmpty()) && isSearchTree(a.getLeft()) ||
                (!a.getRight().getEmpty() && a.getLeft().getEmpty() && !a.getEmpty() && isSearchTree(a.getRight()))
                ) {
            return true;
        } else if (!a.getLeft().getEmpty() && a.getLeft().getValue() >= a.getValue() ||
                !a.getRight().getEmpty() && a.getValue() >= a.getRight().getValue() || max(a.getLeft()) >= a.getValue()
                || min(a.getRight()) <= a.getValue()) {
            return false;
        } else {
            return isSearchTree(a.getLeft()) && isSearchTree(a.getRight());
        }
    }


    /**
     * EXERCISE 5': The inefficient way
     * evaluates whether tree is binary search tree.
     * It first traverses the tree inorder, and then checks whether
     * this list is sorted. If it is, it's a binary search tree.
     *
     * @param a
     * @return
     */
    public static boolean isSearchTreeInefficient(Tree a) {
        if (
                a.getEmpty() ||                                                             // input tree empty
                        (a.getRight().getEmpty() && a.getLeft().getEmpty() && !a.getEmpty()) ||     // input tree is leafnode
                        (a.getRight().getEmpty() && !a.getLeft().getEmpty() && !a.getEmpty()) ||
                        (!a.getRight().getEmpty() && a.getLeft().getEmpty() && !a.getEmpty())
                ) {
            return true;
        } else {
            return sorted(traversalInOrder(a));
        }
    }

    /**
     * EXERCISE 5' - HELPER FUNCTION
     *
     * @param a
     * @return
     */
    public static List traversalInOrder(Tree a) {
        if (a.getEmpty()) {
            return List.empty();
        } else if (a.getValue() == 0) {
            return List.cons(0, List.empty());
        } else {
            return ListOps.append(ListOps.addToEnd(traversalInOrder(a.getLeft()), a.getValue()),
                    traversalInOrder(a.getRight()));
        }
    }

    /**
     * EXERCISE 5' - HELPER FUNCTION
     *
     * @param a
     * @return
     */
    public static boolean sorted(List a) {
        if (a.isEmpty() || a.getTail().isEmpty())
            return true;
        else if (a.getHead() <= a.getTail().getHead()) {
            return (sorted(a.getTail()));
        } else {
            return false;
        }
    }

    /**
     * EXERCISE 6
     *
     * @param a
     */
    public static void printDescending(Tree a) {
        if (!a.getEmpty()) {
            printDescending(a.getRight());
            System.out.print(a.getValue() + " ");
            printDescending(a.getLeft());
        }
    }

    /**
     * EXERCISE 7
     *
     * @param a
     * @return
     */
    public static int max(Tree a) {
        if (a.getEmpty()) throw new IllegalArgumentException("Input tree must have at least 1 element");
        else if (a.getRight().getEmpty()) {
            return a.getValue();
        } else {
            return max(a.getRight());
        }
    }

    public static int min(Tree a) {
        if (a.getEmpty()) throw new IllegalArgumentException("Input tree must have at least 1 element");
        else if (a.getLeft().getEmpty()) {
            return a.getValue();
        } else {
            return min(a.getLeft());
        }
    }

    /**
     * EXERCISE 8: delete(Tree a, int x)
     * Delete first node with value of 'x' from tree 'a'.
     * If the input tree is empty, the same tree is returned
     *
     * @param a
     * @param x
     * @return
     */
    public static Tree delete(Tree a, int x) {
        if (a.getEmpty()) {
            return a;

        } else if (a.getLeft().getEmpty() && a.getRight().getEmpty()) {
            return new Tree();

        } else if (a.getValue() == x) {
            // depending on whether left OR right is empty, make sure the newRootNode value
            // gets deleted from the old list
            if (newRootNode(a) > a.getValue()) {
                return new Tree(newRootNode(a), a.getLeft(), delete(a.getRight(), newRootNode(a)));
            } else {
                return new Tree(newRootNode(a), delete(a.getLeft(), newRootNode(a)), a.getRight());
            }

        } else if (a.getValue() < x) { // if x is on the right
            return new Tree(a.getValue(), a.getLeft(), delete(a.getRight(), x));

        } else if (a.getValue() > x) {
            return new Tree(a.getValue(), delete(a.getLeft(), x), a.getRight());
        } else return a;
    }

    /**
     * EXERCISE 8 - HELPER FUNCTION
     * Determines which value will take the place of the
     * node we're deleting. Either the greatest value of
     * the left branch, or the smallest value of the
     * right branch is returned, depending on availability.
     *
     * @param a
     * @return
     */
    public static int newRootNode(Tree a) {
        if (a.getLeft().getEmpty() && a.getRight().getEmpty()) {
            return 0;
        } else {
            if (a.getLeft().getEmpty() && !a.getRight().getEmpty()) {
                return min(a.getRight());
            } else {
                return max(a.getLeft());
            }
        }
    }

    /**
     * PART B HELPER FUNCTION
     *
     * @param a
     * @return
     */

    public static int balanceFactor(Tree a) {
        if (a.getEmpty() ||
                (a.getLeft().getEmpty() && !a.getRight().getEmpty()) ||
                (!a.getLeft().getEmpty() && a.getRight().getEmpty())) {
            return 0;
        } else { // possible int values: -2, -1, 0, 1, 2
            if (!a.getLeft().getEmpty() && !a.getRight().getEmpty()) {
                return a.getRight().getHeight() - a.getLeft().getHeight();
            } else return 0;
        }
    }

    /**
     * EXERCISE 9
     *
     * @param a
     * @return
     */
    public static boolean isHeightBalanced(Tree a) {
        if (a.getEmpty() ||
                balanceFactor(a) == 1 ||
                balanceFactor(a) == 0 ||
                balanceFactor(a) == -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * PART B HELPER FUNCTION
     *
     * @param a
     * @return
     */
    public static Tree fixBalance(Tree a) {
        if (isHeightBalanced(a)) {
            return a;
        } else {

            if ((balanceFactor(a) == -2) && (balanceFactor(a.getLeft()) == -1 || balanceFactor(a.getLeft()) == 0)) {
                return rotateRight(a);

            } else if ((balanceFactor(a) == -2) && (balanceFactor(a.getLeft()) == 1)) {
                return rotateRight(rotateLeft(a.getLeft()));

            } else if ((balanceFactor(a) == 2) && (balanceFactor(a.getRight()) == 1 || balanceFactor(a.getRight()) == 0)) {
                return rotateLeft(a);

            } else if ((balanceFactor(a) == 2) && (balanceFactor(a.getRight()) == -1)) {
                return rotateLeft(rotateRight(a.getRight()));

            } else {
                return a;
            }
        }
    }

    /**
     * PART B HELPER FUNCTION
     *
     * @param a
     * @return
     */
    public static Tree rotateRight(Tree a) {
        if (a.getEmpty()) {
            return a;
        } else {
            return new Tree(a.getLeft().getValue(), a.getLeft().getLeft(),
                    new Tree(a.getValue(), a.getLeft().getRight(), a.getRight()));
        }
    }

    /**
     * PART B HELPER FUNCTION
     *
     * @param a
     * @return
     */
    public static Tree rotateLeft(Tree a) {
        if (a.getEmpty()) {
            return a;
        } else {
            return new Tree(a.getRight().getValue(),
                    new Tree(a.getValue(), a.getLeft(), a.getRight().getLeft()),
                    new Tree(a.getRight().getRight().getValue(), a.getRight().getRight().getLeft(),
                            a.getRight().getRight().getRight()));
        }
    }

    /**
     * EXERCISE 10 / A
     *
     * @param x
     * @param a
     * @return
     */
    public static Tree insertHB(int x, Tree a) {
        if (a.getEmpty()) {
            return fixBalance(new Tree(x));
        } else if (x < a.getValue()) {
            return fixBalance(new Tree(a.getValue(), insertHB(x, a.getLeft()), a.getRight()));
        } else if (x > a.getValue()) {
            return fixBalance(new Tree(a.getValue(), a.getLeft(), insertHB(x, a.getRight())));
        } else {
            return fixBalance(new Tree(x, a.getLeft(), a.getRight()));
        }
    }

    /**
     * EXERCISE 10 / B
     *
     * @param a
     * @param x
     * @return
     */
    public static Tree deleteHB(Tree a, int x) {
        if (a.getEmpty()) {
            return a;
        } else if (a.getLeft().getEmpty() && a.getRight().getEmpty()) {
            return new Tree();

        } else if (a.getValue() == x) {
            // depending on whether left OR right is empty, make sure the newRootNode value
            // gets deleted from the old list
            if (newRootNode(a) > a.getValue()) {
                return fixBalance(new Tree(newRootNode(a), a.getLeft(), delete(a.getRight(), newRootNode(a))));
            } else {
                return fixBalance(new Tree(newRootNode(a), delete(a.getLeft(), newRootNode(a)), a.getRight()));
            }

        } else if (a.getValue() < x) { // if x is on the right
            return fixBalance(new Tree(a.getValue(), a.getLeft(), delete(a.getRight(), x)));

        } else {
            return fixBalance(new Tree(a.getValue(), delete(a.getLeft(), x), a.getRight()));
        }

    }

    // LOCAL TESTING
    public static void main(String[] args) {
    }
}
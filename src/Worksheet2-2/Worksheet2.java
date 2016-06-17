/**
 * @author This class contains the solution for Worksheet2
 */
public class Worksheet2 implements Worksheet2Interface {
    /**
     * EXERCISE 1
     * Method returns a tree with all elements found in the input tree, but with their values negated.
     * It first checks if the input tree is empty, in which case it returns the same tree (as a tree
     * with no values negated is the same tree). If the tree isn't empty, it multiplies each element
     * by -1.
     *
     * @param t input tree
     * @return input tree with all elements negated
     */
    public static Tree negateAll(Tree t) {
        return (t.getEmpty()) ? t : new Tree(-t.getValue(), negateAll(t.getLeft()), negateAll(t
                .getRight()));
    }

    /**
     * EXERCISE 2
     * Returns a tree with the same values as the input tree, but with its elements mirrored vertically
     * over from left to right & right to left. It first checks if the tree is empty, in which case it
     * returns the same tree, as its mirrored output is identical. if the tree isn't empty, it returns
     * each element from each side placing them on the other side.
     *
     * @param t input tree
     * @return input tree with all its elements mirrored to the opposite side
     */
    public static Tree mirror(Tree t) {
        return (t.getEmpty()) ? t : new Tree(t.getValue(), mirror(t.getRight()), mirror(t.getLeft()));
    }

    /**
     * EXERCISE 3
     * Returns a list containing all the elements of the tree traversed in post order. It checks if the
     * tree is empty, if it is, it returns an empty list. If it isn't empty, it takes the left subtree's
     * node, the right subtree's node and finally the rootnode. It calls the same method recursively on
     * all subsequent subtrees & appends their output to the first list.
     *
     * @param t input tree
     * @return list of all elements traversed in post order
     */
    public static List postOrder(Tree t) {
        return (t.getEmpty()) ? List.empty() : ListOps.addToEnd(ListOps.append(postOrder(t.getLeft()),
                postOrder(t.getRight())), t.getValue());
    }

    /**
     * EXERCISE 4
     *
     * Returns true if all nodes in a tree are positive.
     * If the input tree is empty, it returns true.
     * If it isn't empty, it checks if the root is greater than zero, and then recursively calls the same
     * method on both subtrees. It places all the return values in one boolean condition.
     *
     * @param a input tree
     * @return true if all nodes are positive
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
     * EXERCISE 5
     *
     * revised: 16.05.2016
     *
     * Returns true if the input tree is a valid Binary Search Tree (BST). The tree's BST property is
     * evaluated by checking if:
     *      - the tree is empty - true;
     *      OR if the tree is a leafnode - true;
     *      OR if right subtree is empty, but left subtree isn't & the left subtree is a valid search tree - true;
     *      OR if the right subtree isn't empty, but the left subtree is & the right subtree is a valid search tree -
     *      true;
     *      OR if left subtree isn't empty and its root node is greater than or equal to the original tree's
     *          root node - false;
     *      OR if the right subtree isn't empty and its root node is smaller than or equal to the original tree's
     *          root node - false;
     *      OR if the largest element of the left subtree is greater than or equal to the root node - false;
     *      OR if the smallest element of the right subtree is smaller than or equal to the root node - false;
     *      OR if both the left and the right subtrees are valid search trees
     *
     * Original version commented out
     *
     * @param a input tree
     * @return true if the input tree is a valid BST
     */
    public static boolean isSearchTree(Tree a) {
//        if (a.getEmpty() ||
//                (a.getRight().getEmpty() && a.getLeft().getEmpty() && !a.getEmpty()) ||
//                (a.getRight().getEmpty() && !a.getLeft().getEmpty() && !a.getEmpty()) && isSearchTree(a.getLeft()) ||
//                (!a.getRight().getEmpty() && a.getLeft().getEmpty() && !a.getEmpty() && isSearchTree(a.getRight()))
//                ) {
//            return true;
//        } else if (!a.getLeft().getEmpty() && a.getLeft().getValue() >= a.getValue() ||
//                !a.getRight().getEmpty() && a.getValue() >= a.getRight().getValue() ||
//                max(a.getLeft()) >= a.getValue() ||
//                min(a.getRight()) <= a.getValue()) {
//            return false;
//        } else {
//            return isSearchTree(a.getLeft()) && isSearchTree(a.getRight());
//        }

        // updated version, less clutter & unnecessary basecases
        if (a.getEmpty() || a.getHeight() == 1) {
            return true;
        } else if (!a.getLeft().getEmpty() && a.getRight().getEmpty()) {
            return isSearchTree(a.getLeft());
        } else if (a.getLeft().getEmpty() && !a.getRight().getEmpty()) {
            return isSearchTree(a.getRight());
        } else if (a.getLeft().getValue() < a.getValue() && a.getRight().getValue() > a.getValue()) {
            return true && isSearchTree(a.getLeft()) && isSearchTree(a.getRight());
        } else {
            return false;
        }
    }
//    /**
//     * EXERCISE 5': The inefficient way
//     * evaluates whether tree is binary search tree.
//     * It first traverses the tree in order, and then checks whether
//     * this list is sorted. If it is, it's a binary search tree.
//     *
//     * @param a input tree
//     * @return true if the input tree is a valid BST
//     */
//    public static boolean isSearchTreeInefficient(Tree a) {
//        if (
//                a.getEmpty() ||                                                             // input tree empty
//                        (a.getRight().getEmpty() && a.getLeft().getEmpty() && !a.getEmpty()) ||     // input tree is leafnode
//                        (a.getRight().getEmpty() && !a.getLeft().getEmpty() && !a.getEmpty()) ||
//                        (!a.getRight().getEmpty() && a.getLeft().getEmpty() && !a.getEmpty())
//                ) {
//            return true;
//        } else {
//            return sorted(traversalInOrder(a));
//        }
//    }

//    /**
//     * EXERCISE 5' - HELPER FUNCTION
//     *
//     * @param a
//     * @return
//     */
//    public static List traversalInOrder(Tree a) {
//        if (a.getEmpty()) {
//            return List.empty();
//        } else if (a.getValue() == 0) {
//            return List.cons(0, List.empty());
//        } else {
//            return ListOps.append(ListOps.addToEnd(traversalInOrder(a.getLeft()), a.getValue()),
//                    traversalInOrder(a.getRight()));
//        }
//    }

//    /**
//     * EXERCISE 5' - HELPER FUNCTION
//     *
//     * @param a
//     * @return
//     */
//    public static boolean sorted(List a) {
//        if (a.isEmpty() || a.getTail().isEmpty())
//            return true;
//        else if (a.getHead() <= a.getTail().getHead()) {
//            return (sorted(a.getTail()));
//        } else {
//            return false;
//        }
//    }

    /**
     * EXERCISE 6
     *
     * Prints all elements of the tree in descending order.
     * As long as the input tree is not empty, it recursively calls itself and prints the right subtree's
     * node, the root node and the left subtree's node in respective order.
     * @param a input tree
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
     * Returns the value of the largest node in the tree. If the input tree is empty, an exception is
     * thrown. As long as it there is a right subtree, it recursively calls itself, descending one level
     * with each recursion. When it can no longer go any deeper (it has reached the lowest level) it
     * returns the value of the node it is currently investigating, since it is the largest element
     * in the tree, which is assumed to be a valid search tree.
     *
     * @param a input BST
     * @return value of the largest node in the input tree
     */
    public static int max(Tree a) {
        if (a.getEmpty()) throw new IllegalArgumentException("Input tree must have at least 1 element");
        else if (a.getRight().getEmpty()) {
            return a.getValue();
        } else {
            return max(a.getRight());
        }
    }

    /**
     * EXERCISE 8: delete(Tree a, int x)
     * Delete first node with value of 'x' from tree 'a'.
     * If the input tree is empty, the same tree is returned. If the input tree is leafnode, an empty new
     * tree is returned (as the only element must be the one we're looking to delete). If the node we're
     * looking to delete equals the root node, (and the tree isn't a leafnode), the method finds what
     * element to put in the place of the node it's deleting by calling its helper function, newRootNode.
     * newRootNode returns the value of a node in the tree it takes in as an argument and returns either
     * the largest value of its left subtree (if there IS a left subtree) or the smallest value of its
     * right subtree (if there are no nodes in the left subtree). At this point a new tree is returned
     * using the newly obtained substitute node from newRootNode. The new tree is constructed using
     * a recursive delete call on the tree's left subtree AND the value of newRootNode, if newRootNode returns the
     * substitute from the left subtree, OR a recursive delete call on the tree's right subtree and newRootNode
     * if newRootNode's value is from the right subtree. This is so in order to avoid the duplication of the
     * newly chosen root node.
     * If 'x' is greater than the root node's value, the same delete method is called recursively on the right
     * subtree, whereas if 'x' is smaller than the root node's value, the same delete method is called
     * recursively on the left subtree.
     *
     * @param a input BST
     * @param x node to be deleted
     * @return a new tree, same as 'a' without the 'x' node
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
     * HELPER FUNCTION FOR EXERCISE 8
     *
     * Returns the value of the smallest node in the tree. If the input tree is empty, an exception is
     * thrown. As long as it there is a left subtree, it recursively calls itself, descending one level
     * with each recursion. When it can no longer go any deeper (it has reached the lowest level) it
     * returns the value of the node it is currently investigating, since it is the smallest element
     * in the tree, which is assumed to be a valid search tree.
     *
     * @param a input BST
     * @return value of the smallest node in the input tree
     */
    public static int min(Tree a) {
        if (a.getEmpty()) throw new IllegalArgumentException("Input tree must have at least 1 element");
        else if (a.getLeft().getEmpty()) {
            return a.getValue();
        } else {
            return min(a.getLeft());
        }
    }

    /**
     * EXERCISE 8 - HELPER FUNCTION
     * Determines which value will take the place of the
     * node we're deleting. Either the greatest value of
     * the left branch, or the smallest value of the
     * right branch is returned, depending on their availability.
     *
     * @param a input tree
     * @return value the root node can be substituted with
     */
    public static int newRootNode(Tree a) {
        if (a.getLeft().getEmpty() && a.getRight().getEmpty()) {
            return a.getValue();
        } else {
            if (a.getLeft().getEmpty() && !a.getRight().getEmpty()) {
                return min(a.getRight());
            } else {
                return max(a.getLeft());
            }
        }
    }

    /**
     * HELPER FUNCTION USED THROUGHOUT PART 'B'
     *
     * Returns balance factor of the assumed input BST
     * If the tree is empty, zero is returned. If the tree has a subtree (right OR left)
     * the left subtree's height is subtracted from the right subtree's height.
     * If the tree has TWO subtrees, the left subtree's height is subtracted from
     * the right subtree's height.
     *
     * The returned balance factor may range from -1, to 1 in case of regular AVL trees.
     * The balance factor is used to precisely define the conditions in which the trees
     * are supposed to be height-balanced.
     *
     * @param a input BST
     * @return balance factor as an integer
     */

    public static int balanceFactor(Tree a) {
        if (a.getEmpty())
            return 0;
        else if
                ((a.getLeft().getEmpty() && !a.getRight().getEmpty()) ||
                (!a.getLeft().getEmpty() && a.getRight().getEmpty()))
        {
            return a.getRight().getHeight() - a.getLeft().getHeight();
        } else {
            if (!a.getLeft().getEmpty() && !a.getRight().getEmpty()) {
                return a.getRight().getHeight() - a.getLeft().getHeight();
            } else return 0;
        }
    }

    /**
     * EXERCISE 9
     *
     * Returns true if the input tree is height-balanced.
     * The method uses the balanceFactor helper function to determine the relationship
     * between the two subtrees. If tree is empty, true is returned. Otherwise, if the
     * tree's balance factor is 1 (right subtree 1 node higher than left), 0 (left &
     * right subtrees equal in height) OR -1 (left subtree 1 node higher than the right)
     * it returns true. For every other possibility (non-AVL trees) false is returned.
     *
     * @param a input tree
     * @return true if input tree is height balanced
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
     * HELPER FUNCTION FOR EXERCISE 10
     *
     * Takes a BST as an argument (AVL & non-AVL), checks if its height balance is
     * between -1 and 1 using the isHeightBalanced method, and rebalances the tree
     * in case it returns false.
     *
     * If the tree is height balanced, the same tree is returned.
     *
     * If the left subtree is 2 units higher than the right subtree AND
     * the left subtree's left subtree is 1 unit higher than the left,
     * OR they are equally balanced, a right rotation is performed to achieve the AVL
     * quality.
     *
     * If the left subtree is 2 units higher than the right subtree AND the
     * left subtree's right subtree is 1 unit higher than the left, a right rotation
     * is performed on the output of a left rotation of the left subtree (double rotation)
     * in order to achieve AVL tree quality.
     *
     * If the right subtree is 2 units higher than the left subtree AND
     * the right subtree's right subtree is 1 unit higher than the left,
     * OR they are equally balanced, a right rotation is performed to achieve the AVL
     * tree quality.
     *
     * If the right subtree is 2 units higher than the left subtree AND the
     * right subtree's left subtree is 1 unit higher than the right, a left rotation
     * is performed on the output of a right rotation of the right subtree (double rotation)
     * in order to achieve AVL tree quality.
     *
     * @param a input BST (near-AVL)
     * @return AVL tree
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
     * Returns a new tree with rotated to the right.
     *
     * @param a input BST
     * @return rotated BST
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
     * Returns a new tree with rotated to the left.
     *
     * @param a input BST
     * @return rotated BST
     */
    public static Tree rotateLeft(Tree a) {
        if (a.getEmpty()) {
            return a;
        } else {
            return  new Tree(
                    a.getRight().getValue(),
                    new Tree(
                        a.getValue(),
                        a.getLeft(),
                        a.getRight().getLeft()),
                    new Tree(
                        a.getRight().getRight().getValue(),
                        a.getRight().getRight().getLeft(),
                        a.getRight().getRight().getRight()));
        }
    }

    /**
     * EXERCISE 10 / A
     *
     * Returns the input AVL, with the new node added to it, maintaining the AVL tree quality.
     * If the input tree is empty, a new tree is returned with 'x' as its root node.
     * If 'x' is smaller than the root node, a new tree is returned recursively calling the
     * insertHB method on its left subtree.
     * If 'x' is greater than the root node, a new tree is returned recursively calling the
     * insertHB method on its right subtree.
     * In any other case, a new tree is returned where 'x' is used as the new tree's root node.
     *
     * Every return call is performed using the fixBalance method, which ensures that the AVL
     * tree property is maintained in the cases where the insertion of the new node would render
     * the height difference more than 1 between the lowermost rootnodes in the two subtrees
     * that have both their subtrees.
     *
     * @param x node to add
     * @param a input AVL tree
     * @return AVL tree including all nodes from the input tree AND 'x'
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
     * Returns the input AVL tree without the node 'x' maintaining the original tree's AVL tree quality.
     *
     * FOR DESCRIPTION ON HOW DELETION WORKS SEE EXERCISE 8: delete(Tree a, int x)
     *
     * Every return call is performed using the fixBalance method, which ensures that the AVL
     * tree property is maintained in the cases where the deletion of a node would render
     * the height difference more than 1 between the lowermost rootnodes in the two subtrees
     * that have both their subtrees.
     *
     * @param a input AVL tree
     * @param x node to be deleted
     * @return AVL tree without node 'x'
     */
    public static Tree deleteHB(Tree a, int x) {
        if (a.getEmpty()) {
            return a;
        } else if (a.getLeft().getEmpty() && a.getRight().getEmpty()) {
            return new Tree();
        } else if (a.getValue() == x) {
            if (newRootNode(a) > a.getValue()) {
                return fixBalance(new Tree(newRootNode(a), a.getLeft(), delete(a.getRight(), newRootNode(a))));
            } else {
                return fixBalance(new Tree(newRootNode(a), delete(a.getLeft(), newRootNode(a)), a.getRight()));
            }
        } else if (a.getValue() < x) {
            return fixBalance(new Tree(a.getValue(), a.getLeft(), delete(a.getRight(), x)));
        } else {
            return fixBalance(new Tree(a.getValue(), delete(a.getLeft(), x), a.getRight()));
        }
    }

    public static void main(String[] args) {


    }
}
/**
 * Created by Zsolt Pazmandy on 05/05/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */
public class AVLBSTInsertionPractice implements TreeInterface {

    private static int balanceFactor(Tree a) {
        if (a.getEmpty())
            return 0;
        else if
                ((a.getLeft().getEmpty() && !a.getRight().getEmpty()) ||
                        (!a.getLeft().getEmpty() && a.getRight().getEmpty())) {
            return a.getRight().getHeight() - a.getLeft().getHeight();
        } else {
            if (!a.getLeft().getEmpty() && !a.getRight().getEmpty()) {
                return a.getRight().getHeight() - a.getLeft().getHeight();
            } else return 0;
        }
    }

    private static boolean isHeightBalanced(Tree a) {
        return a.getEmpty() ||
                balanceFactor(a) == 1 ||
                balanceFactor(a) == 0 ||
                balanceFactor(a) == -1;
    }

    private static int min(Tree a) {
        if (a.getEmpty()) throw new IllegalArgumentException("Input tree must have at least 1 element");
        else if (a.getLeft().getEmpty()) {
            return a.getValue();
        } else {
            return min(a.getLeft());
        }
    }

    private static int max(Tree a) {
        if (a.getEmpty()) throw new IllegalArgumentException("Input tree must have at least 1 element");
        else if (a.getRight().getEmpty()) {
            return a.getValue();
        } else {
            return max(a.getRight());
        }
    }

    private static Tree delete(Tree a, int x) {
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

    private static int newRootNode(Tree a) {
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

    private static Tree rotateRight(Tree a) {
        if (a.getEmpty()) {
            return a;
        } else {
            return new Tree(a.getLeft().getValue(),

                    a.getLeft().getLeft(),

                    new Tree(a.getValue(),

                            a.getLeft().getRight(),

                            a.getRight()));
        }
    }

    private static Tree rotateLeft(Tree a) {
        if (a.getEmpty()) {
            return a;
        } else {
            return new Tree(
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

    private static Tree fixBalance(Tree a) {
        if (isHeightBalanced(a)) {
            return a;
        } else {

            if ((balanceFactor(a) == -2) && (balanceFactor(a.getLeft()) == -1 || balanceFactor(a.getLeft()) == 0)) {
                return rotateRight(a);

            } else if ((balanceFactor(a) == -2) && (balanceFactor(a.getLeft()) == 1)) {
//                return rotateRight(rotateLeft(a.getLeft()));
                return rotateRight(doubleRotateD(a)); // the updated double D rotate

            } else if ((balanceFactor(a) == 2) && (balanceFactor(a.getRight()) == 1 || balanceFactor(a.getRight()) == 0)) {
                return rotateLeft(a);

            } else if ((balanceFactor(a) == 2) && (balanceFactor(a.getRight()) == -1)) {
//                return rotateLeft(rotateRight(a.getRight()));
                return rotateLeft(doubleRotateC(a)); // the updated double C rotate

            } else {
                return a;
            }
        }
    }

    private static Tree insertHB(int x, Tree a) {
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

    private static Tree deleteHB(Tree a, int x) {
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

    private static Tree doubleRotateD(Tree a) {
        if (a.getEmpty()){
            return a;
        } else {
            return new Tree(a.getValue(), a.getLeft(), new Tree(a.getRight().getLeft().getValue(),a.getRight().getLeft().getLeft(), new Tree(a.getRight().getValue(), a.getRight().getLeft().getRight(), a.getRight().getRight())));
        }
    }

    private static Tree doubleRotateC(Tree a) {
        if (a.getEmpty()){
            return a;
        } else {
            return  new Tree(
                            a.getValue(),
                            new Tree(
                                    a.getLeft().getRight().getValue(),
                                    a.getLeft().getRight().getRight(),
                                    new Tree(
                                            a.getLeft().getValue(),
                                            a.getLeft().getLeft(),
                                            a.getLeft().getRight().getRight())), a.getRight());
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70), new Tree(80))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128), new Tree(140))));
        System.out.println(t);
        System.out.println(deleteHB(deleteHB(deleteHB(deleteHB(deleteHB(deleteHB(t, 90),80), 95), 100), 130), 97));
    }
}

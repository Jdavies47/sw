import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author ZSOLT PAZMANDY
 */

public class Worksheet2Test {

    /**
     * TEST#1: negateAll(Tree a)
     * 
     * Test case 1. Empty input tree.
     * Test case 2. Input tree with 0 as its node.
     * Test case 3. Input tree of all negative nodes.
     * Test case 4. Input tree of all positive nodes.
     * Test case 5. Input tree of mixed positive & negative nodes.
     */
    @Test
    public void negateAllTest() {
        Tree expectedTree1 = new Tree();
        Tree expectedTree2 = new Tree(0);
        Tree expectedTree3 = new Tree(12, new Tree(6, new Tree(654, new Tree(235), new Tree(76)), new Tree(765, new Tree(346), new Tree(346))), new Tree(356, new Tree(234, new Tree(87), new Tree(245)), new Tree(1, new Tree(2465), new Tree(3))));
        Tree expectedTree4 = new Tree(-22, new Tree(-92, new Tree(-761, new Tree(-27), new Tree(-65)), new Tree(-123, new Tree(-53), new Tree(-2))), new Tree(-6521, new Tree(-432, new Tree(-132), new Tree(-542)), new Tree(-321, new Tree(-83), new Tree(-123))));
        Tree expectedTree5 = new Tree(996, new Tree(-12, new Tree(7661, new Tree(-863), new Tree(6415)), new Tree(-5, new Tree(111), new Tree(-20))), new Tree(21, new Tree(-92, new Tree(582), new Tree(-514)), new Tree(8, new Tree(-831), new Tree(6541))));

        Tree actualTree1 = Worksheet2.negateAll(new Tree());
        Tree actualTree2 = Worksheet2.negateAll(new Tree(0));
        Tree actualTree3 = Worksheet2.negateAll(new Tree(-12, new Tree(-6, new Tree(-654, new Tree(-235), new Tree(-76)), new Tree(-765, new Tree(-346), new Tree(-346))), new Tree(-356, new Tree(-234, new Tree(-87), new Tree(-245)), new Tree(-1, new Tree(-2465), new Tree(-3)))));
        Tree actualTree4 = Worksheet2.negateAll(new Tree(22, new Tree(92, new Tree(761, new Tree(27), new Tree(65)), new Tree(123, new Tree(53), new Tree(2))), new Tree(6521, new Tree(432, new Tree(132), new Tree(542)), new Tree(321, new Tree(83), new Tree(123)))));
        Tree actualTree5 = Worksheet2.negateAll(new Tree(-996, new Tree(12, new Tree(-7661, new Tree(863), new Tree(-6415)), new Tree(5, new Tree(-111), new Tree(20))), new Tree(-21, new Tree(92, new Tree(-582), new Tree(514)), new Tree(-8, new Tree(831), new Tree(-6541)))));

        assertEquals(expectedTree1, actualTree1);
        assertEquals(expectedTree2, actualTree2);
        assertEquals(expectedTree3, actualTree3);
        assertEquals(expectedTree4, actualTree4);
        assertEquals(expectedTree5, actualTree5);

    }

    /**
     * TEST#2: mirror(Tree a)
     * 
     * Test case 1. Empty input tree.
     * Test case 2. Input tree of one sub-tree on the left.
     * Test case 3. Input tree of one sub-tree on the right.
     * Test case 4. Input tree of two non-empty sub-trees.
     */
    @Test
    public void mirrorTest() {
        Tree expectedTree1 = new Tree();
        Tree expectedTree2 = new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree());
        Tree expectedTree3 = new Tree(30, new Tree(), new Tree(20, new Tree(25, new Tree(27), new Tree(23)), new Tree(15, new Tree(18), new Tree(12))));
        Tree expectedTree4 = new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree(40, new Tree(35, new Tree(33), new Tree(36)), new Tree(45, new Tree(42), new Tree(50))));

        Tree actualTree1 = Worksheet2.mirror(new Tree());
        Tree actualTree2 = Worksheet2.mirror(new Tree(30, new Tree(), new Tree(20, new Tree(25, new Tree(27), new Tree(23)), new Tree(15, new Tree(18), new Tree(12)))));
        Tree actualTree3 = Worksheet2.mirror(new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree()));
        Tree actualTree4 = Worksheet2.mirror(new Tree(30, new Tree(40, new Tree(45, new Tree(50), new Tree(42)), new Tree(35, new Tree(36), new Tree(33))), new Tree(20, new Tree(25, new Tree(27), new Tree(23)), new Tree(15, new Tree(18), new Tree(12)))));

        assertEquals(expectedTree1, actualTree1);
        assertEquals(expectedTree2, actualTree2);
        assertEquals(expectedTree3, actualTree3);
        assertEquals(expectedTree4, actualTree4);

    }

    /**
     * TEST#3: postOrder(Tree a)
     * 
     * Test case 1. Empty input tree.
     * Test case 2. Input tree of two sub-trees.
     * Test case 3. Input tree of one sub-tree on the left.
     * Test case 4. Input tree of one sub-tree on the right.
     * Test case 5. Input tree is a leaf node.
     */
    @Test
    public void postOrderTest() {
        List expectedList1 = new List();
        List expectedList2 = List.cons(12, List.cons(18, List.cons(15, List.cons(23, List.cons(27, List.cons(25, List.cons(20, List.cons(33, List.cons(36, List.cons(35, List.cons(42, List.cons(50, List.cons(45, List.cons(40, List.cons(30, List.empty())))))))))))))));
        List expectedList3 = List.cons(12, List.cons(18, List.cons(15, List.cons(23, List.cons(27, List.cons(25, List.cons(20, List.cons(30, List.empty()))))))));
        List expectedList4 = List.cons(27, List.cons(23, List.cons(25, List.cons(18, List.cons(12, List.cons(15, List.cons(20, List.cons(30, List.empty()))))))));
        List expectedList5 = List.cons(5, List.empty());

        List actualList1 = Worksheet2.postOrder(new Tree());
        List actualList2 = Worksheet2.postOrder(new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree(40, new Tree(35, new Tree(33), new Tree(36)), new Tree(45, new Tree(42), new Tree(50)))));
        List actualList3 = Worksheet2.postOrder(new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree()));
        List actualList4 = Worksheet2.postOrder(new Tree(30, new Tree(), new Tree(20, new Tree(25, new Tree(27), new Tree(23)), new Tree(15, new Tree(18), new Tree(12)))));
        List actualList5 = Worksheet2.postOrder(new Tree(5));

        assertEquals(expectedList1, actualList1);
        assertEquals(expectedList2, actualList2);
        assertEquals(expectedList3, actualList3);
        assertEquals(expectedList4, actualList4);
        assertEquals(expectedList5, actualList5);

    }

    /**
     * TEST#4: allPositive(Tree a)
     * 
     * Test case 1. Empty input tree.
     * Test case 2. Input tree with 0 as its node.
     * Test case 3. Input tree of all negative nodes.
     * Test case 4. Input tree of all positive nodes.
     * Test case 5. Input tree of mixed positive & negative nodes.
     */
    @Test
    public void allPositiveTest() {
        boolean expectedBool1 = true;
        boolean expectedBool2 = true;
        boolean expectedBool3 = false;
        boolean expectedBool4 = true;
        boolean expectedBool5 = false;

        boolean actualBool1 = Worksheet2.allPositive(new Tree());
        boolean actualBool2 = Worksheet2.allPositive(new Tree(0));
        boolean actualBool3 = Worksheet2.allPositive(new Tree(-22, new Tree(-92, new Tree(-761, new Tree(-27), new Tree(-65)), new Tree(-123, new Tree(-53), new Tree(-2))), new Tree(-6521, new Tree(-432, new Tree(-132), new Tree(-542)), new Tree(-321, new Tree(-83), new Tree(-123)))));
        boolean actualBool4 = Worksheet2.allPositive(new Tree(12, new Tree(6, new Tree(654, new Tree(235), new Tree(76)), new Tree(765, new Tree(346), new Tree(346))), new Tree(356, new Tree(234, new Tree(87), new Tree(245)), new Tree(1, new Tree(2465), new Tree(3)))));
        boolean actualBool5 = Worksheet2.allPositive(new Tree(996, new Tree(-12, new Tree(7661, new Tree(-863), new Tree(6415)), new Tree(-5, new Tree(111), new Tree(-20))), new Tree(21, new Tree(-92, new Tree(582), new Tree(-514)), new Tree(8, new Tree(-831), new Tree(6541)))));

        assertEquals(expectedBool1, actualBool1);
        assertEquals(expectedBool2, actualBool2);
        assertEquals(expectedBool3, actualBool3);
        assertEquals(expectedBool4, actualBool4);
        assertEquals(expectedBool5, actualBool5);
    }

    /**
     * TEST#5: isSearchTree(Tree a)
     * 
     * Test case 1. Input tree is empty.
     * Test case 2. Input tree has no sub-trees.
     * Test case 3. Input tree is a valid search tree.
     * Test case 4. Input tree is not a valid search tree.
     */
    @Test
    public void isSearchTreeTest() {
        boolean expectedBool1 = true;
        boolean expectedBool2 = true;
        boolean expectedBool3 = true;
        boolean expectedBool4 = false;

        boolean actualBool1 = Worksheet2.isSearchTree(new Tree());
        boolean actualBool2 = Worksheet2.isSearchTree(new Tree(4));
        boolean actualBool3 = Worksheet2.isSearchTree(new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree(40, new Tree(35, new Tree(33), new Tree(36)), new Tree(45, new Tree(42), new Tree(50)))));
        boolean actualBool4 = Worksheet2.isSearchTree(new Tree(12, new Tree(6, new Tree(654, new Tree(235), new Tree(76)), new Tree(765, new Tree(346), new Tree(346))), new Tree(356, new Tree(234, new Tree(87), new Tree(245)), new Tree(1, new Tree(2465), new Tree(3)))));

        assertEquals(expectedBool1, actualBool1);
        assertEquals(expectedBool2, actualBool2);
        assertEquals(expectedBool3, actualBool3);
        assertEquals(expectedBool4, actualBool4);

    }

//    /**
//     * TEST#6: isSearchTreeInefficient(Tree a)
//     *
//     * Test case 1. Input tree is empty.
//     * Test case 2. Input tree has no sub-trees.
//     * Test case 3. Input tree is a valid search tree.
//     * Test case 4. Input tree is not a valid search tree.
//     */
//    @Test
//    public void isSearchTreeInefficientTest() {
//        boolean expectedBool1 = true;
//        boolean expectedBool2 = true;
//        boolean expectedBool3 = true;
//        boolean expectedBool4 = false;
//
//        boolean actualBool1 = Worksheet2.isSearchTreeInefficient(new Tree());
//        boolean actualBool2 = Worksheet2.isSearchTreeInefficient(new Tree(4));
//        boolean actualBool3 = Worksheet2.isSearchTreeInefficient(new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree(40, new Tree(35, new Tree(33), new Tree(36)), new Tree(45, new Tree(42), new Tree(50)))));
//        boolean actualBool4 = Worksheet2.isSearchTreeInefficient(new Tree(12, new Tree(6, new Tree(654, new Tree(235), new Tree(76)), new Tree(765, new Tree(346), new Tree(346))), new Tree(356, new Tree(234, new Tree(87), new Tree(245)), new Tree(1, new Tree(2465), new Tree(3)))));
//
//        assertEquals(expectedBool1, actualBool1);
//        assertEquals(expectedBool2, actualBool2);
//        assertEquals(expectedBool3, actualBool3);
//        assertEquals(expectedBool4, actualBool4);
//    }

    /**
     * TEST#7: traversalInOrder(Tree a)
     * 
     * Test case 1. Empty input tree.
     * Test case 2. Input tree of two sub-trees.
     * Test case 3. Input tree of one sub-tree on the left.
     * Test case 4. Input tree of one sub-tree on the right.
     * Test case 5. Input tree is a leafnode.
     */
    @Test
    public void traversalInOrderTest() {
        List expectedList1 = new List();
        List expectedList2 = new List(12, List.cons(15, List.cons(18, List.cons(20, List.cons(23, List.cons(25, List.cons(27, List.cons(30, List.cons(33, List.cons(35, List.cons(36, List.cons(40, List.cons(42, List.cons(45, List.cons(50, List.empty())))))))))))))));
        List expectedList3 = new List(12, List.cons(15, List.cons(18, List.cons(20, List.cons(23, List.cons(25, List.cons(27, List.cons(30, List.empty()))))))));
        List expectedList4 = new List(30, List.cons(27, List.cons(25, List.cons(23, List.cons(20, List.cons(18, List.cons(15, List.cons(12, List.empty()))))))));
        List expectedList5 = new List(5, List.empty());

        List actualList1 = Worksheet2.postOrder(new Tree());
        List actualList2 = Worksheet2.postOrder(new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree(40, new Tree(35, new Tree(33), new Tree(36)), new Tree(45, new Tree(42), new Tree(50)))));
        List actualList3 = Worksheet2.postOrder(new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree()));
        List actualList4 = Worksheet2.postOrder(new Tree(30, new Tree(), new Tree(20, new Tree(25, new Tree(27), new Tree(23)), new Tree(15, new Tree(18), new Tree(12)))));
        List actualList5 = Worksheet2.postOrder(new Tree(5));
    }

    /**
     * TEST#8: max(Tree a)
     * 
     * Test case 1. Empty input tree.
     * Test case 2. Input tree has no sub-trees.
     * Test case 3. Input tree has one sub-tree on the left.
     * Test case 4. Input tree has one sub-tree on the right.
     * Test case 5. Input tree has two non-empty sub-trees.
     */
    @Test
    public void maxTest() {
//        int expectedMax1 = 0; exception thrown
        int expectedMax2 = 5;
        int expectedMax3 = 30;
        int expectedMax4 = 58;
        int expectedMax5 = 28;

//        int actualMax1 =;
        int actualMax2 = Worksheet2.max(new Tree(5));
        int actualMax3 = Worksheet2.max(new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree()));
        int actualMax4 = Worksheet2.max(new Tree(30, new Tree(), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58)))));
        int actualMax5 = Worksheet2.max(new Tree(5, new Tree(3), new Tree(8, new Tree(6), new Tree(25, new Tree(15), new Tree(28)))));

        assertEquals(expectedMax2, actualMax2);
        assertEquals(expectedMax3, actualMax3);
        assertEquals(expectedMax4, actualMax4);
        assertEquals(expectedMax5, actualMax5);

    }

    /**
     * TEST#9: min(Tree a)
     * 
     * Test case 1. Empty input tree.
     * Test case 2. Input tree has no sub-trees.
     * Test case 3. Input tree has one sub-tree on the left.
     * Test case 4. Input tree has one sub-tree on the right.
     * Test case 5. Input tree has two non-empty sub-trees.
     */
    @Test
    public void minTest() {
//        int expectedMin1 = 0; exception thrown
        int expectedMin2 = 5;
        int expectedMin3 = 12;
        int expectedMin4 = 30;
        int expectedMin5 = 3;

//        int actualMin1 =;
        int actualMin2 = Worksheet2.min(new Tree(5));
        int actualMin3 = Worksheet2.min(new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree()));
        int actualMin4 = Worksheet2.min(new Tree(30, new Tree(), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58)))));
        int actualMin5 = Worksheet2.min(new Tree(5, new Tree(3), new Tree(8, new Tree(6), new Tree(25, new Tree(15), new Tree(28)))));

        assertEquals(expectedMin2, actualMin2);
        assertEquals(expectedMin3, actualMin3);
        assertEquals(expectedMin4, actualMin4);
        assertEquals(expectedMin5, actualMin5);
    }

    /**
     * TEST#10: delete(Tree a, int x)
     * 
     * Test cases:
     * Node to be deleted is:
     * 1. in the left sub-tree, has no children.
     * 2. in the left sub-tree, has one left child.
     * 3. in the left sub-tree, has one right child.
     * 4. in the right sub-tree, has no children.
     * 5. in the right sub-tree, has one left child.
     * 6. in the right sub-tree, has one right child.
     * 7. the root node.
     */
    @Test
    public void deleteTest() {
        Tree expectedTree1 = new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70),new Tree())), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128), new Tree(140))));
        Tree expectedTree2 = new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree((70))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128), new Tree(140))));
        Tree expectedTree3 = new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree((80))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128), new Tree(140))));
        Tree expectedTree4 = new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70), new Tree(80))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128), new Tree())));
        Tree expectedTree5 = new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70),new Tree(80))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(128, new Tree(), new Tree())));
        Tree expectedTree6 = new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70),new Tree(80))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(140, new Tree(), new Tree())));
        Tree expectedTree7 = new Tree();

        Tree actualTree1 = Worksheet2.delete(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70), new Tree(80))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128), new Tree(140)))), 80);
        Tree actualTree2 = Worksheet2.delete(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)),new Tree(75, new Tree(70),new Tree())), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128), new Tree(140)))), 75);
        Tree actualTree3 = Worksheet2.delete(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, (new Tree()),new Tree(80))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128), new Tree(140)))), 75);
        Tree actualTree4 = Worksheet2.delete(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70),new Tree(80))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128), new Tree(140)))), 140);
        Tree actualTree5 = Worksheet2.delete(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70),new Tree(80))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128), new Tree()))), 130);
        Tree actualTree6 = Worksheet2.delete(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70),new Tree(80))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(), new Tree(140)))), 130);
        Tree actualTree7 = Worksheet2.delete(new Tree(10), 10);

        assertEquals(expectedTree1, actualTree1);
        assertEquals(expectedTree2, actualTree2);
        assertEquals(expectedTree3, actualTree3);
        assertEquals(expectedTree4, actualTree4);
        assertEquals(expectedTree5, actualTree5);
        assertEquals(expectedTree6, actualTree6);
        assertEquals(expectedTree7, actualTree7);
    }

    /**
     * TEST#11: newRootNode(Tree a)
     * 
     * Test case 1. Empty input tree.
     * Test case 2. Input tree has no sub-trees.
     * Test case 3. Input tree has one sub-tree on the left.
     * Test case 4. Input tree has one sub-tree on the right.
     * Test case 5. Input tree has two sub-trees.
     */
    @Test
    public void newRootNodeTest() {
//        int expectedRootNode1 = ; throw exception
        int expectedRootNode2 = 5;
        int expectedRootNode3 = 30;
        int expectedRootNode4 = 58;
        int expectedRootNode5 = 28;

//        int actualRootNode1 =;
        int actualRootNode2 = Worksheet2.max(new Tree(5));
        int actualRootNode3 = Worksheet2.max(new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree()));
        int actualRootNode4 = Worksheet2.max(new Tree(30, new Tree(), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58)))));
        int actualRootNode5 = Worksheet2.max(new Tree(5, new Tree(3), new Tree(8, new Tree(6), new Tree(25, new Tree(15), new Tree(28)))));

        assertEquals(expectedRootNode2, actualRootNode2);
        assertEquals(expectedRootNode3, actualRootNode3);
        assertEquals(expectedRootNode4, actualRootNode4);
        assertEquals(expectedRootNode5, actualRootNode5);
    }

    /**
     * TEST#12: balanceFactor(Tree a)
     * 
     * Test case 1. Empty input tree.
     * Test case 2. Input tree has no sub-trees.
     * Test case 3. Input tree has one sub-tree on the left.
     * Test case 4. Input tree has one sub-tree on the right.
     * Input tree has two sub-trees:
     * 5. Right sub-tree & left sub-tree same height.
     * 6. Right sub-tree 1 node shorter than left.
     * 7. Right sub-tree 1 node higher than left.
     * 8. Right sub-tree 2 nodes shorter than left.
     * 9. Right sub-tree 2 nodes higher than left.
     */
    @Test
    public void balanceFactorTest() {
        int expectedBalance1 = 0;
        int expectedBalance2 = 0;
        int expectedBalance3 = -3;
        int expectedBalance4 = 3;
        int expectedBalance5 = 0;
        int expectedBalance6 = -1;
        int expectedBalance7 = 1;
        int expectedBalance8 = -2;
        int expectedBalance9 = 2;

        int actualBalance1 = Worksheet2.balanceFactor(new Tree());
        int actualBalance2 = Worksheet2.balanceFactor(new Tree(5));
        int actualBalance3 = Worksheet2.balanceFactor(new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree()));
        int actualBalance4 = Worksheet2.balanceFactor(new Tree(30, new Tree(), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58)))));
        int actualBalance5 = Worksheet2.balanceFactor(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70), new Tree(80))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128), new Tree(140)))));
        int actualBalance6 = Worksheet2.balanceFactor(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70), new Tree(80))), new Tree(100, new Tree(95), new Tree(105))));
        int actualBalance7 = Worksheet2.balanceFactor(new Tree(90, new Tree(50, new Tree(46), new Tree(52)), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128),new Tree(140)))));
        int actualBalance8 = Worksheet2.balanceFactor(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70),new Tree(80))), new Tree(100, new Tree(), new Tree())));
        int actualBalance9 = Worksheet2.balanceFactor(new Tree(90, new Tree(50, new Tree(), new Tree()), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128),new Tree(140)))));

        assertEquals(expectedBalance1, actualBalance1);
        assertEquals(expectedBalance2, actualBalance2);
        assertEquals(expectedBalance3, actualBalance3);
        assertEquals(expectedBalance4, actualBalance4);
        assertEquals(expectedBalance5, actualBalance5);
        assertEquals(expectedBalance6, actualBalance6);
        assertEquals(expectedBalance7, actualBalance7);
        assertEquals(expectedBalance8, actualBalance8);
        assertEquals(expectedBalance9, actualBalance9);
    }

    /**
     * TEST#13: isHeightBalanced(Tree a)
     * 
     * ASSUMED: AVL BST input. (exc. cases 8 & 9)
     * 
     * Test case 1. Empty input tree.
     * Test case 2. Input tree has no sub-trees.
     * Test case 3. Input tree has one sub-tree on the left.
     * Test case 4. Input tree has one sub-tree on the right.
     * Input tree has two sub-trees:
     * 5. Right sub-tree & left sub-tree same height.
     * 6. Right sub-tree 1 node shorter than left.
     * 7. Right sub-tree 1 node higher than left.
     * 8. Right sub-tree 2 nodes shorter than left.
     * 9. Right sub-tree 2 nodes higher than left.
     */
    @Test
    public void isHeightBalancedTest() {

        boolean expectedBool1 = true;
        boolean expectedBool2 = true;
        boolean expectedBool3 = false;
        boolean expectedBool4 = false;
        boolean expectedBool5 = true;
        boolean expectedBool6 = true;
        boolean expectedBool7 = true;
        boolean expectedBool8 = false;
        boolean expectedBool9 = false;

        boolean actualBool1 = Worksheet2.isHeightBalanced(new Tree());
        boolean actualBool2 = Worksheet2.isHeightBalanced(new Tree(5));
        boolean actualBool3 = Worksheet2.isHeightBalanced(new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree()));
        boolean actualBool4 = Worksheet2.isHeightBalanced(new Tree(30, new Tree(), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58)))));
        boolean actualBool5 = Worksheet2.isHeightBalanced(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70), new Tree(80))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128), new Tree(140)))));
        boolean actualBool6 = Worksheet2.isHeightBalanced(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70), new Tree(80))), new Tree(100, new Tree(95), new Tree(105))));
        boolean actualBool7 = Worksheet2.isHeightBalanced(new Tree(90, new Tree(50, new Tree(46), new Tree(52)), new Tree (100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128),                        new Tree(140)))));
        boolean actualBool8 = Worksheet2.isHeightBalanced(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70),new Tree(80))), new Tree(100, new Tree(), new Tree())));
        boolean actualBool9 = Worksheet2.isHeightBalanced(new Tree(90, new Tree(50, new Tree(), new Tree()), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128),new Tree(140)))));

        assertEquals(expectedBool1, actualBool1);
        assertEquals(expectedBool2, actualBool2);
        assertEquals(expectedBool3, actualBool3);
        assertEquals(expectedBool4, actualBool4);
        assertEquals(expectedBool5, actualBool5);
        assertEquals(expectedBool6, actualBool6);
        assertEquals(expectedBool7, actualBool7);
        assertEquals(expectedBool8, actualBool8);
        assertEquals(expectedBool9, actualBool9);
    }

    /**
     * TEST#14: fixBalance(Tree a)
     * 
     * ASSUMED: AVL BST input. (exc. cases 8 & 9)
     * 
     * Test case 1. Empty input tree.
     * Test case 2. Input tree has no sub-trees.
     * Test case 3. Input tree has one sub-tree on the left.
     * Test case 4. Input tree has one sub-tree on the right.
     * Input tree has two sub-trees:
     * 5. Right sub-tree & left sub-tree same height.
     * 6. Right sub-tree 1 node shorter than left.
     * 7. Right sub-tree 1 node higher than left.
     * 8. Right sub-tree 2 nodes shorter than left.
     * 9. Right sub-tree 2 nodes higher than left.
     */
    @Test
    public void fixBalanceTest() {
        Tree expectedTree1 = new Tree();
        Tree expectedTree2 = new Tree(5);
        Tree expectedTree3 = new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree());
        Tree expectedTree4 = new Tree(30, new Tree(), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58))));
        Tree expectedTree5 = new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70), new Tree(80))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128), new Tree(140))));
        Tree expectedTree6 = new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70), new Tree(80))), new Tree(100, new Tree(95), new Tree(105)));
        Tree expectedTree7 = new Tree(90, new Tree(50, new Tree(46), new Tree(52)), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128),new Tree(140))));
        Tree expectedTree8 = new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(90, new Tree(75, new Tree(70), new Tree(80)), new Tree(100)));
        Tree expectedTree9 = new Tree(100, new Tree(90, new Tree(50), new Tree(95, new Tree(92), new Tree(97))), new Tree(130, new Tree(128), new Tree(140)));

        Tree actualTree1 = Worksheet2.fixBalance(new Tree());
        Tree actualTree2 = Worksheet2.fixBalance(new Tree(5));
        Tree actualTree3 = Worksheet2.fixBalance(new Tree(30, new Tree(20, new Tree(15, new Tree(12), new Tree(18)), new Tree(25, new Tree(23), new Tree(27))), new Tree()));
        Tree actualTree4 = Worksheet2.fixBalance(new Tree(30, new Tree(), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58)))));
        Tree actualTree5 = Worksheet2.fixBalance(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70), new Tree(80))), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128), new Tree(140)))));
        Tree actualTree6 = Worksheet2.fixBalance(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70), new Tree(80))), new Tree(100, new Tree(95), new Tree(105))));
        Tree actualTree7 = Worksheet2.fixBalance(new Tree(90, new Tree(50, new Tree(46), new Tree(52)), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128),new Tree(140)))));
        Tree actualTree8 = Worksheet2.fixBalance(new Tree(90, new Tree(50, new Tree(35, new Tree(30), new Tree(45)), new Tree(75, new Tree(70),new Tree(80))), new Tree(100, new Tree(), new Tree())));
        Tree actualTree9 = Worksheet2.fixBalance(new Tree(90, new Tree(50, new Tree(), new Tree()), new Tree(100, new Tree(95, new Tree(92), new Tree(97)), new Tree(130, new Tree(128),new Tree(140)))));

        assertEquals(expectedTree1, actualTree1);
        assertEquals(expectedTree2, actualTree2);
        assertEquals(expectedTree3, actualTree3);
        assertEquals(expectedTree4, actualTree4);
        assertEquals(expectedTree5, actualTree5);
        assertEquals(expectedTree6, actualTree6);
        assertEquals(expectedTree7, actualTree7);
        assertEquals(expectedTree8, actualTree8);
        assertEquals(expectedTree9, actualTree9);
    }


    /**
     * TEST#15: insertHB(int x, Tree a)
     * 
     * ASSUMED: AVL BST input.
     * 
     * Test case 1. Empty input tree.
     * Test case 2. Input tree has no sub-trees.
     * Test case 3. Sub-tree on the left is longer than right by 1 &
     * node is to be added to the left.
     * Test case 4. Sub-tree on the left is longer than right by 1 &
     * node is to be added to the right
     * Test case 5. Sub-tree on the right is longer than left by 1 &
     * node is to be added to the left.
     * Test case 6. Sub-tree on the right is longer than left by 1 &
     * node is to be added to the right.
     */
    @Test
    public void insertHBTest() {
        Tree expectedTree1 = new Tree(5);
        Tree expectedTree2 = new Tree(7, new Tree(5), new Tree());
        Tree expectedTree3 = new Tree(30, new Tree(20, new Tree(15, new Tree(13), new Tree(18)), new Tree(27, new Tree(25, new Tree(23), new Tree(26)), new Tree(28, new Tree(), new Tree(29)))), new Tree(50, new Tree(40,new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58))));
        Tree expectedTree4 = new Tree(30, new Tree(20, new Tree(15, new Tree(13), new Tree(18)), new Tree(25, new Tree(23), new Tree(27, new Tree(26), new Tree(28)))), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58, new Tree(), new Tree(60)))));
        Tree expectedTree5 = new Tree(30, new Tree(20, new Tree(15), new Tree(25, new Tree(), new Tree(26))), new Tree(50,new Tree(40,new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58))));
        Tree expectedTree6 = new Tree(50, new Tree(30, new Tree(20, new Tree(15), new Tree(25)), new Tree(40, new Tree(35), new Tree(42))), new Tree(55, new Tree(52), new Tree(58, new Tree(), new Tree(60))));

        Tree actualTree1 = Worksheet2.insertHB(5, new Tree());
        Tree actualTree2 = Worksheet2.insertHB(5, new Tree(7));
        Tree actualTree3 = Worksheet2.insertHB(29, new Tree(30, new Tree(20, new Tree(15, new Tree(13), new Tree(18)), new Tree(25, new Tree(23), new Tree(27, new Tree(26), new Tree(28)))), new Tree(50, new Tree (40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58)))));
        Tree actualTree4 = Worksheet2.insertHB(60, new Tree(30, new Tree(20, new Tree(15, new Tree(13), new Tree(18)), new Tree(25, new Tree(23), new Tree(27, new Tree(26), new Tree(28)))), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58)))));
        Tree actualTree5 = Worksheet2.insertHB(26, new Tree(30, new Tree(20, new Tree(15), new Tree(25)), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58)))));
        Tree actualTree6 = Worksheet2.insertHB(60, new Tree(30, new Tree(20, new Tree(15), new Tree(25)), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58)))));

        assertEquals(expectedTree1, actualTree1);
        assertEquals(expectedTree2, actualTree2);
        assertEquals(expectedTree3, actualTree3);
        assertEquals(expectedTree4, actualTree4);
        assertEquals(expectedTree5, actualTree5);
        assertEquals(expectedTree6, actualTree6);
    }

    /**
     * TEST#16: deleteHB(Tree a, int x)
     * 
     * ASSUMED: AVL BST input.
     * 
     * Test case 1. Empty input tree.
     * Test case 2. Input tree has no sub-trees.
     * Test case 3. Sub-tree on the left is longer than right by 1 &
     * node is to be deleted from the left.
     * Test case 4. Sub-tree on the left is longer than right by 1 &
     * node is to be deleted from the right
     * Test case 5. Sub-tree on the right is longer than left by 1 &
     * node is to be deleted from the left.
     * Test case 6. Sub-tree on the right is longer than left by 1 &
     * node is to be deleted from the right.
     */
    @Test
    public void deleteHBTest() {
        Tree expectedTree1 = new Tree();
        Tree expectedTree2 = new Tree();
        Tree expectedTree3 = new Tree(30, new Tree(20, new Tree(15, new Tree(13), new Tree(18)), new Tree(25, new Tree(23), new Tree(27, new Tree(26), new Tree()))), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58))));
        Tree expectedTree4 = new Tree(30, new Tree(20, new Tree(15, new Tree(13), new Tree(18)), new Tree(25, new Tree(23), new Tree(27, new Tree(26), new Tree(28)))), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree())));
        Tree expectedTree5 = new Tree(30, new Tree(20, new Tree(15), new Tree()), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58))));
        Tree expectedTree6 = new Tree(30, new Tree(20, new Tree(15), new Tree(25)), new Tree(42, new Tree(40, new Tree(35), new Tree()), new Tree(55, new Tree(52), new Tree(58))));

        Tree actualTree1 = Worksheet2.deleteHB(new Tree(), 1);
        Tree actualTree2 = Worksheet2.deleteHB(new Tree(5), 5);
        Tree actualTree3 = Worksheet2.deleteHB(new Tree(30, new Tree(20, new Tree(15, new Tree(13), new Tree(18)), new Tree(25, new Tree(23), new Tree(27, new Tree(26), new Tree(28)))), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58)))), 28);
        Tree actualTree4 = Worksheet2.deleteHB(new Tree(30, new Tree(20, new Tree(15, new Tree(13), new Tree(18)), new Tree(25, new Tree(23), new Tree(27, new Tree(26), new Tree(28)))), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58)))), 58);
        Tree actualTree5 = Worksheet2.deleteHB(new Tree(30, new Tree(20, new Tree(15), new Tree(25)), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58)))), 25);
        Tree actualTree6 = Worksheet2.deleteHB(new Tree(30, new Tree(20, new Tree(15), new Tree(25)), new Tree(50, new Tree(40, new Tree(35), new Tree(42)), new Tree(55, new Tree(52), new Tree(58)))), 50);

        assertEquals(expectedTree1, actualTree1);
        assertEquals(expectedTree2, actualTree2);
        assertEquals(expectedTree3, actualTree3);
        assertEquals(expectedTree4, actualTree4);
        assertEquals(expectedTree5, actualTree5);
        assertEquals(expectedTree6, actualTree6);
    }
}

package tree;
import list.List;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;


/**
 * provides a few utility methods and examples of how to manipulate
 * trees, including a useful print method.
 */
class TreeOps extends Tree {

    /**
     * This was done in the Lecture
     *@return the height of the tree
     */
    public static int height(Tree t) {
        if (t.getEmpty())
            return 0;
	else {   
            int leftHeight = height(t.getLeft());
            int rightHeight = height(t.getRight());
            
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * Returns an entirely new tree whose elements are triple that of
     * the input Tree
     */
    public static Tree triple(Tree t) {
	if (t.getEmpty())
	    return new Tree();
	else
	    return new Tree(3*t.getValue(), triple(t.getLeft()), triple(t.getRight()));
    }

     /**
     * Returns a List of values obtained by visiting the Tree in in-order.
     * eg. left branch, then current root, then right branch. 
     */
    public static List inorder(Tree t) {
        if (t.getEmpty()) 
            return List.empty();
         else {
            return list.ListOps.append(inorder(t.getLeft()), 
            		List.cons(t.getValue(), inorder(t.getRight())));
        }
    }
     
    private static Iterator<Tree> getChildrenIterator(Tree t) {
        if (t.getEmpty())
            return Collections.<Tree>emptyList().iterator();
	else
	    return Arrays.asList(new Tree[] { 
		    t.getRight(),
		    t.getLeft()}).iterator();    
    }

}

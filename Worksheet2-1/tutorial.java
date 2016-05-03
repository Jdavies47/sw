/*AVL TREES
	- GEORGY ADELSON-VELSKY EVGERI LONDIS TREE (AVL)
	- SELF-BALANCING BINARY SEARCH TREE
	- THE HEIGHTS OF THE 2 CHILD SUBTREES OF ANY NODE DIFFER BY AT MOST 1

	- IF THE DIFFERENCE IS MORE THAN 1, IT NEEDS TO BE RE-BALANCED
	- AN L-ONLY TREE OR AN R-ONLY TREE IS EASIER TO RE-BALANCE THAN A ZIG-ZAG TREE
	*/


	static Tree negateAll(Tree a){
		if (Tree.isEmpty()){
			return Tree.empty();
		} else {
			return createNode(-a.root(), negateAll(a.Left, negateAll(a.Right)));
		}
	}

	static boolean isSearchTree(Tree a){
		if (Tree.isEmpty()){
			return true;
		} else if (
	}
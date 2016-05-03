public Tree treeInsert(int x, Tree T){
	if(T.isEmpty()){
		return new Tree(x);
	} else {
		if(x == a){
			return T;
		} else if(x < a){
			Tree L = T.getLeft;
			Tree R = T.getRight;
			return new Tree (a, treeInsert(x,L), R);
		} else {
			Tree L = T.getLeft;
			Tree R = T.getRight;
			return new Tree (a, TreeInsert(x,R), L);
		}
}
// efficiency: the algorithm travels down only one side ~ hopefully log2N
// log2N <= h <= N
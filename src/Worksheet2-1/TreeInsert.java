//public Tree treeInsert(int x, Tree T){
//	if(T.isEmpty()){
//		return new Tree(x);
//	} else {
//		if(x == T.getValue()){
//			return T;
//		} else if(x < T.getValue()){
//			return new Tree (T.getValue(), treeInsert(x,T.getLeft()), T.getRight());
//		} else {
//			return new Tree (T.getValue(), TreeInsert(x,T.getRight()), T.getLeft());
//		}
//}
// efficiency: the algorithm travels down only one side ~ hopefully log2N
// log2N <= h <= N
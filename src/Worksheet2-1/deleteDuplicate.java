public class deleteDuplicate{
	public static List deleteDuplicate (int x, List L){
		if(L.isEmpty()) {
			return List.empty();		
		} else {
			if(x==L.getHead()){
				return L.getTail();
			} else {
				List R = deleteDuplicate (x, L.getTail());
				return List.cons(L.getHead(), R);
			}
		}
	}

	public static void main(String[] args) {
		List L = List.cons(21,List.cons(10,List.cons(15,List.cons(98,List.cons(1,List.cons(1,List.cons(4,List.empty())))))));
		System.out.println(L);
		System.out.println(deleteDuplicate(1, L));
	}
}
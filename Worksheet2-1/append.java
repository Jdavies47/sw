// append one list (M) to another (L)
public class append implements Worksheet1Interface{
	public static List append(List L, List M){
		if(L.isEmpty())
			return M;
		else {
		List R = append(L.getTail(),M);
		return List.cons(L.getHead(),R);
		}
	}
}
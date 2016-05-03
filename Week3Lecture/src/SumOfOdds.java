
public class SumOfOdds {
	private static int num;
	private static int sum;
	private static int i=0;
	
	public SumOfOdds(int num, int sum) {
		super();
		this.num = num;
		this.sum = sum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public static void main(String[] args) {
		
	SumOfOdds s = new SumOfOdds(0,0);
	for (i=0; i <= 100; i++){
		if (s.getNum() % 2 != 0){
			s.setSum(sum + num);
			System.out.println(" + " + s.getNum());
		}
		num++;
	}
	
	System.out.printf("------\n= " + s.getSum());
}

}

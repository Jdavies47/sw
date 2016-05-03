package tryingAlotHarder;

public class assignment {
	/**
	 * Calculate integer part of square root. requires n >= 0
	 * 
	 * @param n
	 *            number to find the square root of
	 * @return an integer s such that s*s <= n and (s+1)*(s+1) > n
	 */
	private static int iSqrt(int n) {
		int l = 0;
		int r = n;

		/*
		 * loop invariant: 0 <= l <= r <= n < (n+1)*(n+1) if i < l, then i^2 <=
		 * n if i >= r, then (i+1)^2 > n
		 */
		while (l < r) {
			int m = (l + r + 1) / 2;
			if (m * m <= n) {
				l = m;
			} else {
				r = m - 1;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		// System.out.println(iSqrt(16));
		iSqrt(25);
	}
}

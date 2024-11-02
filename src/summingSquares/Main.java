package summingSquares;

import java.util.HashMap;

/*****************************************************
 * n = length of nums Time: O(n * sqrt(n)) Space: O(n)
 *****************************************************/

public class Main {

	public static void main(String[] args) {
		int n = 12;
		summingSquares(n);
	}

	public static void summingSquares(int n) {
		int min_squares = (int) summingSquares(n, new HashMap<>());
		System.out.println("Minimum square needed: " + min_squares);
	}

	public static double summingSquares(int n, HashMap<Integer, Double> memo) {
		if (n < 0) {
			return Double.POSITIVE_INFINITY;
		}

		if (n == 0) {
			return 0.;
		}

		if (memo.containsKey(n)) {
			return memo.get(n);
		}

		Double minSquares = Double.POSITIVE_INFINITY;
		for (int i = 1; i <= Math.sqrt(n); i += 1) {
			int square = i * i;
			double numSquares = 1 + summingSquares(n - square, memo);
			if (numSquares < minSquares) {
				minSquares = numSquares;
			}
		}

		memo.put(n, minSquares);
		return minSquares;
	}

}

package tribonacci;

import java.util.HashMap;

/*************************
 * Time: O(n) Space: O(n)
 *************************/

public class Main {

	public static void main(String[] args) {
		int n = 8;
		System.out.println(n + "th tribonacci number is: " + trib(n));

	}

	private static int trib(int n) {

		return trib(n, new HashMap<Integer, Integer>());
	}

	private static int trib(int n, HashMap<Integer, Integer> memo) {
		if (n == 0 || n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		if (memo.containsKey(n)) {

			return memo.get(n);
		}

		int result = trib(n - 3, memo) + trib(n - 2, memo) + trib(n - 1, memo);
		memo.put(n, result);
		return result;
	}

}

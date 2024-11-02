package fibonacci;

import java.util.HashMap;

/*************************
 * Time: O(n) Space: O(n)
 *************************/

public class Main {

	public static void main(String[] args) {
		int n = 6;
		System.out.println(n + "th fibonacci number is: " + fib(n));

	}

	public static int fib(int n) {
		return fib(n, new HashMap<>());
	}

	public static int fib(int n, HashMap<Integer, Integer> memo) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (memo.containsKey(n)) {
			return memo.get(n);
		}

		int result = fib(n - 2, memo) + fib(n - 1, memo);
		memo.put(n, result);

		return result;
	}

}

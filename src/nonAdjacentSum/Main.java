package nonAdjacentSum;

import java.util.HashMap;
import java.util.List;

/********************************************
 * n = length of numbers Time: O(n) Space: O(n)
 *********************************************/

public class Main {

	public static void main(String[] args) {

		/* List<Integer> nums = List.of(2, 4, 5, 12, 7); */
		List<Integer> nums = List.of(72, 62, 10, 6, 20, 19, 42, 46, 24, 78, 50, 20);
		nonAdjacentSum(nums);

	}

	private static void nonAdjacentSum(List<Integer> nums) {

		int sum = nonAdjacentSum(0, nums, new HashMap<Integer, Integer>());
		System.out.println("Maximum Sum of non adjacent element: " + sum);
	}

	private static int nonAdjacentSum(int i, List<Integer> nums, HashMap<Integer, Integer> memo) {
		if (i >= nums.size()) {

			return 0;
		}
		if (memo.containsKey(i)) {

			return memo.get(i);
		}

		int result = Math.max(nums.get(i) + nonAdjacentSum(i + 2, nums, memo), nonAdjacentSum(i + 1, nums, memo));
		memo.put(i, result);
		return result;

	}

}

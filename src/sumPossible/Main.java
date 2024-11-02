package sumPossible;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/************************************************************
 * a = amount n = length of numbers Time: O(a*n) Space: O(a)
 ************************************************************/

public class Main {

	public static void main(String[] args) {
		int targetAmount = 15;
		List<Integer> numbers = new LinkedList<Integer>();
		numbers.add(9);
		numbers.add(6);
		numbers.add(4);
		System.out.println(numbers);

		boolean possible = sumPos(targetAmount, numbers, new HashMap<Integer, Boolean>());
		System.out.println(possible);
	}

	private static boolean sumPos(int targetAmount, List<Integer> numbers, HashMap<Integer, Boolean> memo) {
		if (targetAmount == 0) {

			return true;
		}
		if (targetAmount < 0) {

			return false;
		}
		if (memo.containsKey(targetAmount)) {

			return memo.get(targetAmount);
		}

		for (int num : numbers) {

			int subAmount = targetAmount - num;
			if ((boolean) sumPos(subAmount, numbers, memo)) {
				memo.put(targetAmount, true);
				return true;
			}

		}
		memo.put(targetAmount, false);
		return false;
	}

}

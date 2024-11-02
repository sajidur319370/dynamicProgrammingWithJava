package countingChange;

import java.util.HashMap;
import java.util.List;

/*****************************************************
 * a = amount c = # coins Time: O(a*c) Space: O(a*c)
 *****************************************************/

public class Main {

	public static void main(String[] args) {

		countingChange(8, List.of(1, 2, 3));

	}

	private static void countingChange(int amount, List<Integer> coins) {

		int min_coin = countingChange(amount, coins, 0, new HashMap<List<Integer>, Integer>());
		System.out.println("There are " + min_coin + " different ways to make an amount of " + amount);
	}

	private static int countingChange(int amount, List<Integer> coins, int coin_index,
			HashMap<List<Integer>, Integer> memo) {

		if (amount == 0) {

			return 1;
		}
		if (coin_index == coins.size()) {

			return 0;
		}
		List<Integer> key = List.of(amount, coin_index);
		if (memo.containsKey(key)) {

			return memo.get(key);
		}

		int total_path = 0;

		for (int quantity = 0; quantity * coins.get(coin_index) <= amount; quantity++) {

			int sub_amount = amount - (quantity * coins.get(coin_index));
			total_path += countingChange(sub_amount, coins, coin_index + 1, memo);

		}

		memo.put(key, total_path);
		return total_path;

	}

}

package minChange;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*************************************************
 * a = amount c = # coins Time: O(a*c) Space: O(a)
 *************************************************/

public class Main {

	public static void main(String[] args) {
		int amount = 4;
		List<Integer> coins = new LinkedList<Integer>();
		coins.add(1);
		coins.add(2);
		coins.add(3);
		coins.add(4);

		int min_coins = minChange(amount, coins, new HashMap<>());
		System.out.println("Minimum coins needed: " + min_coins);

	}

	public static int minChange(int amount, List<Integer> coins, HashMap<Integer, Integer> memo) {
		if (amount == 0) {
			return 0;
		}

		if (amount < 0) {
			return -1;
		}

		if (memo.containsKey(amount)) {
			return memo.get(amount);
		}

		int minCoins = -1;
		for (int coin : coins) {
			int subAmount = amount - coin;
			int subCoins = minChange(subAmount, coins, memo);
			if (subCoins != -1) {
				int numCoins = 1 + subCoins;
				if (numCoins < minCoins || minCoins == -1) {
					minCoins = numCoins;
				}
			}
		}

		memo.put(amount, minCoins);
		return minCoins;
	}

}

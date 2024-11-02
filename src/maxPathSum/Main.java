package maxPathSum;

import java.util.HashMap;
import java.util.List;

/********************************************************
 * r = # rows c = # columns Time: O(r*c) Space: O(r*c)
 ********************************************************/
public class Main {

	public static void main(String[] args) {

		List<List<Integer>> grid = List.of(List.of(1, 2, 8, 1), List.of(3, 10, 12, 10), List.of(4, 0, 6, 3));
		/*
		 * 
		 * List.of( List.of(1, 2, 8, 1), List.of(3, 10, 12, 10), List.of(4, 0, 6, 3) );
		 * 
		 */

		maxPathSum(grid);

	}

	private static void maxPathSum(List<List<Integer>> grid) {

		double totalPath = maxPathSum(0, 0, grid, new HashMap<List<Integer>, Double>());
		System.out.println("Sum of Maximum Path is:" + totalPath);
	}

	private static double maxPathSum(int r, int c, List<List<Integer>> grid, HashMap<List<Integer>, Double> memo) {
		if (r == grid.size() || c == grid.get(0).size()) {

			return Double.NEGATIVE_INFINITY;
		}
		if (r == grid.size() - 1 && c == grid.get(0).size() - 1) {

			return grid.get(r).get(c);
		}

		List<Integer> position = List.of(r, c);
		if (memo.containsKey(position)) {

			return memo.get(position);
		}

		double result = grid.get(r).get(c)
				+ Math.max(maxPathSum(r + 1, c, grid, memo), maxPathSum(r, c + 1, grid, memo));
		memo.put(position, result);
		return result;
	}

}

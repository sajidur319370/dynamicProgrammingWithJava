package countPath;

import java.util.HashMap;
import java.util.List;

/****************************************************
 * r = # rows c = # columns Time: O(r*c) Space: O(r*c)
 *****************************************************/

public class Main {

	public static void main(String[] args) {

		List<List<String>> grid = List.of(List.of("O", "O", "X"), List.of("O", "O", "O"), List.of("O", "O", "O"));
		/***********************************
		 * List.of( List.of("O", "O", "X"), List.of("O", "O", "O"), List.of("O", "O",
		 * "O") );
		 ***********************************/
		countPath(grid);

	}

	private static void countPath(List<List<String>> grid) {

		int totalPath = countPath(0, 0, grid, new HashMap<List<Integer>, Integer>());
		System.out.println("Total Path is:" + totalPath);
	}

	private static int countPath(int r, int c, List<List<String>> grid, HashMap<List<Integer>, Integer> memo) {
		if (r == grid.size() || c == grid.get(0).size()) {

			return 0;
		}
		if (r == grid.size() - 1 && c == grid.get(0).size() - 1) {

			return 1;
		}
		if (grid.get(r).get(c) == "X") {

			return 0;
		}

		List<Integer> position = List.of(r, c);
		if (memo.containsKey(position)) {

			return memo.get(position);
		}

		int result = countPath(r + 1, c, grid, memo) + countPath(r, c + 1, grid, memo);
		memo.put(position, result);
		return result;
	}

}

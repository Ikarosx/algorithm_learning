package leetcode.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 * @author Ikaros
 *
 */
public class N279 {
	public int numSquares(int n) {
		Queue<IntPair> queue = new LinkedList<IntPair>();
		queue.add(new IntPair(n, 0));
		boolean[] visited = new boolean[n + 1];
		visited[n] = true;
		while (!queue.isEmpty()) {
			IntPair remove = queue.remove();
			int num = remove.a;
			int step = remove.b;

			for (int i = 1;; i++) {
				int a = num - i * i;
				if (a < 0) {
					break;
				}
				if (a == 0) {
					return step + 1;
				}
				if (!visited[a]) {
					queue.add(new IntPair(a, step + 1));
					visited[a] = true;
				}
			}
		}
		return 0;
	}

	class IntPair {
		int a;
		int b;

		public IntPair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

	}
}

package leetcode.stackandqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 * @author Ikaros
 *
 */
public class N199 {
	public List<Integer> rightSideView(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		if (root == null) {
			return result;
		}
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(root, 0));
		int count = 0;
		while (!queue.isEmpty()) {
			Pair remove = queue.remove();
			int n = remove.n;
			TreeNode node = remove.node;
			if (count == n) {
				result.add(node.val);
				count++;
			}
			if (node.right != null) {
				queue.add(new Pair(node.right, n + 1));
			}
			if (node.left != null) {
				queue.add(new Pair(node.left, n + 1));
			}

		}

		return result;
	}
}

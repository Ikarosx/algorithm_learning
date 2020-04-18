package leetcode.stackandqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * @author Ikaros
 *
 */
public class N103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(root, 0));
		while (!queue.isEmpty()) {
			Pair remove = queue.remove();
			int n = remove.n;
			TreeNode node = remove.node;
			if (n == result.size()) {
				result.add(new LinkedList<Integer>());
			}
			if (n % 2 == 0) {
				result.get(n).add(node.val);
			} else {
				result.get(n).add(0, node.val);
			}
			if (node.left != null) {
				queue.add(new Pair(node.left, n + 1));
			}
			if (node.right != null) {
				queue.add(new Pair(node.right, n + 1));
			}
		}

		return result;
	}
}

package leetcode.stackandqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 * @author Ikaros
 *
 */
public class N107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
				result.addFirst(new LinkedList<Integer>());
			}
			result.get(0).add(node.val);
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

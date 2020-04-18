package leetcode.stackandqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * @author Ikaros
 *
 */
public class N102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(root, 0));
		while (!queue.isEmpty()) {
			Pair pop = queue.remove();
			if (pop.n == result.size()) {
				result.add(new LinkedList<Integer>());
			}
			result.get(result.size() - 1).add(pop.node.val);
			if (pop.node.left != null) {
				queue.add(new Pair(pop.node.left, pop.n + 1));
			}
			if (pop.node.right != null) {
				queue.add(new Pair(pop.node.right, pop.n + 1));
			}
		}
		return result;
	}
}

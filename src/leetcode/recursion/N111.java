package leetcode.recursion;

/**
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
 * @author Ikaros
 *
 */
public class N111 {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left != null && root.right != null) {
			return 1 + Math.min(minDepth(root.left), minDepth(root.right));
		}
		if (root.left != null) {
			return 1 + minDepth(root.left);
		} else {
			return 1 + minDepth(root.right);
		}
	}
}

package leetcode.stackandqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?
 * @author Ikaros
 *
 */
public class N144 {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null) {
			result.add(root.val);
			if (root.right != null) {
				stack.push(root.right);
			}
			root = root.left;
			if (root == null && !stack.isEmpty()) {
				root = stack.pop();
			}
		}
		return result;
	}

}

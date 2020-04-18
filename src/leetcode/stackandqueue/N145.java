package leetcode.stackandqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?
 * @author Ikaros
 *
 */
public class N145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				result.addFirst(cur.val);
				cur = cur.right;
			} else {
				cur = stack.pop().left;
			}
		}
		return result;
	}
}

package leetcode.stackandqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class N94 {
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			result.add(cur.val);
			cur = cur.right;
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode aNode = new TreeNode(1);
		TreeNode treeNode = new TreeNode(2);
		aNode.left = treeNode;
		treeNode.left = new TreeNode(4);
		treeNode.right = new TreeNode(5);
		TreeNode treeNode2 = new TreeNode(3);
		aNode.right = treeNode2;
		treeNode2.right = new TreeNode(6);
		List<Integer> inorderTraversal = inorderTraversal(aNode);
		System.out.println(inorderTraversal);
	}

}

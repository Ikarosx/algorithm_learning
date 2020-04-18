package leetcode.stackandqueue;

public class Test {
	public static void main(String[] args) {
		TreeNode aNode = new TreeNode(1);
		TreeNode treeNode = new TreeNode(2);
		aNode.left = treeNode;
		treeNode.left = new TreeNode(4);
		treeNode.right = new TreeNode(5);
		TreeNode treeNode2 = new TreeNode(3);
		aNode.right = treeNode2;
		treeNode2.right = new TreeNode(6);
		inorder(aNode);
	}

	public static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.println(root.val);
			inorder(root.right);
		}
	}
}

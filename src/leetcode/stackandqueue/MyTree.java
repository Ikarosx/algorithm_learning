package leetcode.stackandqueue;

public class MyTree {

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Pair {
	TreeNode node;
	int n;

	public Pair(TreeNode node, int n) {
		super();
		this.node = node;
		this.n = n;
	}

}
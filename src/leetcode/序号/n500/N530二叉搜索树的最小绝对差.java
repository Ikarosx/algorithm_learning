package leetcode.序号.n500;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

示例：

输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。

提示：

	树中至少有 2 个节点。
	本题与 783 <a href="https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/">https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/</a> 相同


相关标签：
	树
	深度优先搜索
	广度优先搜索
	二叉搜索树
	二叉树

原题地址：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
  
 *  
 * @author Ikarosx 
 * @date 2021/7/7 
 */ 
 public class N530二叉搜索树的最小绝对差 {

 	private int pre = -1;
 	private int val = Integer.MAX_VALUE;
	public int getMinimumDifference(TreeNode root) {
		dfs(root);
		return val;
	}

	// 中序遍历
	private void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		dfs(root.left);
		if (pre != -1) {
			val = Math.min(Math.abs(pre - root.val), val);
		}
		pre = root.val;
		dfs(root.right);
	}

}
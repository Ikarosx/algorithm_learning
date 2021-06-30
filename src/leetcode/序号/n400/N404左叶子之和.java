package leetcode.序号.n400;

import com.sun.corba.se.spi.ior.IORFactories;
import 剑指offer.TreeNode;

/**
 * 计算给定二叉树的所有左叶子之和。

示例：

    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24


相关标签：
	树
	深度优先搜索
	广度优先搜索
	二叉树

原题地址：https://leetcode-cn.com/problems/sum-of-left-leaves/
  
 *  
 * @author Ikarosx 
 * @date 2021/6/30 
 */ 
 public class N404左叶子之和 {
	/**
	 * DFS
	 */
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int result = 0;
		if (root.left != null && root.left.left == null && root.left.right == null) {
			result += root.left.val;
		}
		return result + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}
 	 
 } 
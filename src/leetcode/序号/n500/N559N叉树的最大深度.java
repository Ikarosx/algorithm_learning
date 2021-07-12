package leetcode.序号.n500;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。

<p class="MachineTrans-lang-zh-CN">最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

<p class="MachineTrans-lang-zh-CN">N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。

<p class="MachineTrans-lang-zh-CN">&nbsp;

示例 1：

<img style="width: 100%; max-width: 300px;" src="https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png">

输入：root = [1,null,3,2,4,null,5,6]
输出：3

示例 2：

<img style="width: 296px; height: 241px;" src="https://assets.leetcode.com/uploads/2019/11/08/sample_4_964.png" alt="">

输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：5

提示：

	树的深度不会超过&nbsp;1000 。
	树的节点数目位于 [0,&nbsp;10<sup>4</sup>] 之间。


相关标签：
	树
	深度优先搜索
	广度优先搜索

原题地址：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
  
 *  
 * @author Ikarosx 
 * @date 2021/7/12 
 */ 
 public class N559N叉树的最大深度 {
	class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}
	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		} else if (root.children.isEmpty()) {
			return 1;
		}
		List<Integer> integers = new LinkedList<>();
		for (Node child : root.children) {
			integers.add(maxDepth(child));
		}
		return Collections.max(integers) + 1;
	}

}
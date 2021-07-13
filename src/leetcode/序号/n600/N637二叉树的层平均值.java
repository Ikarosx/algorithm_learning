package leetcode.序号.n600;

import org.junit.Test;
import 剑指offer.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 * <p>
 * 提示：
 * <p>
 * 节点值的范围在32位有符号整数范围内。
 * <p>
 * <p>
 * 相关标签：
 * 树
 * 深度优先搜索
 * 广度优先搜索
 * 二叉树
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 *
 * @author Ikarosx
 * @date 2021/7/13
 */
public class N637二叉树的层平均值 {
	@Test
	public void test () {
		System.out.println(averageOfLevels(new TreeNode(2)));
	}

    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
		LinkedList<Double> result = new LinkedList<>();
		while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            int tempSize = size;
            while (tempSize-- > 0) {
                TreeNode pop = queue.pop();
                sum += pop.val;
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
            result.add(sum / (size + 0.0));
        }
		return result;
    }
}
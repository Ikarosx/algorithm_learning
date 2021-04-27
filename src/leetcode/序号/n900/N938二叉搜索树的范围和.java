package leetcode.序号.n900;

import 剑指offer.TreeNode;

/**
 * 给定二叉搜索树的根结点&nbsp;root，返回值位于范围 <em>[low, high]</em> 之间的所有结点的值的和。
 * <p>
 * 示例 1：
 * <img style="width: 400px; height: 222px;" src="https://assets.leetcode.com/uploads/2020/11/05/bst1.jpg" alt="">
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * <p>
 * 示例 2：
 * <img style="width: 400px; height: 335px;" src="https://assets.leetcode.com/uploads/2020/11/05/bst2.jpg" alt="">
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 2 * 10<sup>4</sup>] 内
 * 1 <= Node.val <= 10<sup>5</sup>
 * 1 <= low <= high <= 10<sup>5</sup>
 * 所有 Node.val 互不相同
 * <p>
 * <p>
 * 相关标签：
 * 树
 * 深度优先搜索
 * 递归
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/range-sum-of-bst/
 *
 * @author Ikarosx
 * @date 2021/4/27
 */
public class N938二叉搜索树的范围和 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSumBSTImpl(root, low, high);
    }

    private int rangeSumBSTImpl(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        if (node.val > high) {
            return rangeSumBSTImpl(node.left, low, high);
        }
        if (node.val < low) {
            return rangeSumBSTImpl(node.right, low, high);
        }
        return node.val + rangeSumBSTImpl(node.left, low, high) + rangeSumBSTImpl(node.right, low, high);
    }
}
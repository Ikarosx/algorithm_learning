package contest.top100CN;

import 剑指offer.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * @author Ikarosx
 * @date 2020/8/5 8:28
 */
public class N124二叉树中的最大路径和 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // 计算左右结点的最大单路径和
        // 然后取大值
        maxPathSumImpl(root);
        return max;
    }

    private int maxPathSumImpl(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(maxPathSumImpl(root.left), 0);
        int r = Math.max(maxPathSumImpl(root.right), 0);
        int result = Math.max(l, r) + root.val;
        if (l + r + root.val > max) {
            max = l + r + root.val;
        }
        return result;
    }

}

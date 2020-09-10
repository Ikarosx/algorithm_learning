package leetcode.剑指offer.N61_;

import 剑指offer.TreeNode;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * @author Ikarosx
 * @date 2020/9/9 8:30
 */
public class N54二叉搜索树的第k大节点 {

    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }

}

package contest.top100CN;

import 剑指offer.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author Ikarosx
 * @date 2020/7/16 9:17
 */
public class N236二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}

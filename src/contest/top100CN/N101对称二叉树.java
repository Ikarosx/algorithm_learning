package contest.top100CN;

import 剑指offer.TreeNode;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author Ikaros
 * @date 2020/7/6 7:51
 */
public class N101对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricImpl(root.left, root.right);
    }
    
    private boolean isSymmetricImpl(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricImpl(left.left, right.right) && isSymmetricImpl(left.right, right.left);
    }
}

package leetcode.序号.n100;

import 剑指offer.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @author Ikarosx
 * @date 2021/1/3 19:24
 */
public class N110平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左子树高度和右子树高度相差不超过1
        if (Math.abs(calcHeight(root.left) - calcHeight(root.right)) > 1) {
            return false;
        }
        // 且左子树是平衡，右子树也是平衡
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int calcHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(calcHeight(node.left), calcHeight(node.right)) + 1;
    }
}

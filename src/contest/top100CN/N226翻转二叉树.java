package contest.top100CN;

import 剑指offer.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author Ikarosx
 * @date 2020/7/15 8:21
 */
public class N226翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);
        TreeNode temp = leftTree;
        root.left = rightTree;
        root.right = temp;
        return root;
    }
    
}

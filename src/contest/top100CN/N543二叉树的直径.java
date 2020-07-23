package contest.top100CN;

import 剑指offer.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * @author Ikarosx
 * @date 2020/7/22 20:45
 */
public class N543二叉树的直径 {
    int max = 1;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        diameterOfBinaryTreeImpl(root);
        return max;
    }
    
    private int diameterOfBinaryTreeImpl(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = diameterOfBinaryTreeImpl(root.left) + 1;
        int right = diameterOfBinaryTreeImpl(root.right) + 1;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}

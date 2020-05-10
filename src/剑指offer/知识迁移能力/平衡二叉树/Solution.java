package 剑指offer.知识迁移能力.平衡二叉树;

import 剑指offer.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * <p>
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 *
 * @author Ikaros
 * @date 2020/5/6 21:37
 */
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }
    
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return 1 + (left > right ? left : right);
        }
    }
}

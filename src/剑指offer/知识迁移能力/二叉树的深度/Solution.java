package 剑指offer.知识迁移能力.二叉树的深度;

import 剑指offer.TreeNode;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *
 * @author Ikaros
 * @date 2020/5/6 20:25
 */
public class Solution {
    
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
    
    
}

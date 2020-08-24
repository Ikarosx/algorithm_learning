package leetcode.剑指offer.N21_40;

import 剑指offer.TreeNode;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * @author Ikarosx
 * @date 2020/8/24 17:46
 */
public class N27二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }

}

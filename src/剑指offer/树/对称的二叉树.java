package 剑指offer.树;

import 剑指offer.TreeNode;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * @author Ikaros
 * @date 2020/5/9 0:35
 */
public class 对称的二叉树 {
    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || isSymmetricalImpl(pRoot.left, pRoot.right);
    }
    
    private boolean isSymmetricalImpl(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricalImpl(left.left, right.right) && isSymmetricalImpl(left.right, right.left);
    }
}

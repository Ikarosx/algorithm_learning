package 剑指offer.面试思路.二叉树的镜像;

import org.junit.jupiter.api.Test;
import 剑指offer.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * @author Ikaros
 * @date 2020/03/12 13:52
 */
class SolutionTest {
    public void Mirror(TreeNode root) {
        /*
         * 递归反转左右子树
         */
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
    
    @Test
    void solution() {
    
    }
}

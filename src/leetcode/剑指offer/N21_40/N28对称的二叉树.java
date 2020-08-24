package leetcode.剑指offer.N21_40;

import org.junit.Test;
import 剑指offer.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/8/24 17:49
 */
public class N28对称的二叉树 {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricImpl(root.left, root.right);
    }

    private boolean isSymmetricImpl(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return isSymmetricImpl(A.left, B.right) && isSymmetricImpl(A.right, B.left);
    }

}

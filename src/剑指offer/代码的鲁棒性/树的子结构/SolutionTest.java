package 剑指offer.代码的鲁棒性.树的子结构;

import org.junit.jupiter.api.Test;
import 剑指offer.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author Ikaros
 * @date 2020/03/12 11:25
 */
class SolutionTest {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return hasSubTree(root1, root2);
    }
    
    private boolean hasSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
        }
        return isSameTree(root1, root2) || hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
    }
    
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
    
    @Test
    void solution() {
        long l = System.currentTimeMillis();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode4.right = treeNode6;
        treeNode4.left = treeNode5;
        System.out.println(HasSubtree(treeNode1, treeNode4));
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}

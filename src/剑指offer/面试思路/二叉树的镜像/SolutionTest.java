package 剑指offer.面试思路.二叉树的镜像;

import org.junit.jupiter.api.Test;

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

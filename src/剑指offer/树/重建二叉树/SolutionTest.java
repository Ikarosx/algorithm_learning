package 剑指offer.树.重建二叉树;

import org.junit.jupiter.api.Test;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author Ikaros
 * @date 2020/03/08 08:20
 */
class SolutionTest {
  public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
    /*
     * 思路：
     * 前序为根左右，中序为左根右
     * 根据前序的第一个值可以得到根节点
     * 然后根据此从中序遍历数组中划分出该根节点的左部分和右部分的中序遍历
     * 又可以根据这两部分从前序遍历数组中划分出该根节点的左部分和右部分的前序遍历
     * 循环反复
     * 这里我遇到的问题是，一开始为了方便在每次分左右时都用了System.arraycopy
     * 230ms左右
     * 改进成用preLeft, preRight, inLeft, inRight四个flag来标记
     * 190ms左右
     * 但这个改的过程暴露了我的逻辑不清晰。。
     * 改了半小时
     */
    if (pre == null || in == null) {
      return null;
    }
    return reConstructBinaryTreeImpl(pre, 0, pre.length - 1, in, 0, in.length - 1);
    //    TreeNode root = new TreeNode(pre[0]);
    //    int rootIn = 0;
    //    for (int i = 0; i < in.length; i++) {
    //      // 找到中序遍历中的根节点
    //      if (in[i] == pre[0]) {
    //        // 得出左部分的中序遍历
    //        rootIn = i;
    //        break;
    //      }
    //    }
    //    // 右边部分
    //    if (rootIn != in.length - 1) {
    //      int[] rightIn = new int[in.length - rootIn - 1];
    //      System.arraycopy(in, rootIn + 1, rightIn, 0, rightIn.length);
    //      int[] rightPre = new int[in.length - rootIn - 1];
    //      System.arraycopy(pre, rootIn + 1, rightPre, 0, rightPre.length);
    //      root.right = reConstructBinaryTree(rightPre, rightIn);
    //    }
    //    // 左边部分
    //    if (rootIn != 0) {
    //      int[] leftIn = new int[rootIn];
    //      System.arraycopy(in, 0, leftIn, 0, rootIn);
    //      int[] leftPre = new int[rootIn];
    //      System.arraycopy(pre, 1, leftPre, 0, rootIn);
    //      root.left = reConstructBinaryTree(leftPre, leftIn);
    //    }
    //    return root;
  }

  private TreeNode reConstructBinaryTreeImpl(
      int[] pre, int preLeft, int preRight, int[] in, int inLeft, int inRight) {
    if (pre == null || in == null) {
      return null;
    }
    TreeNode root = new TreeNode(pre[preLeft]);
    int rootIn = -1;
    for (int i = inLeft; i <= inRight; i++) {
      // 找到中序遍历中的根节点
      if (in[i] == pre[preLeft]) {
        // 得出左部分的中序遍历
        rootIn = i;
        break;
      }
    }
    // 右边部分
    if (rootIn != inRight) {
      root.right = reConstructBinaryTreeImpl(pre, preLeft + rootIn - inLeft + 1, preRight, in, rootIn + 1, inRight);
    }
    // 左边部分
    if (rootIn != inLeft) {
      root.left = reConstructBinaryTreeImpl(pre, preLeft + 1, rootIn, in, inLeft, rootIn - 1);
    }
    return root;
  }

  @Test
  void solution() {
    long l = System.currentTimeMillis();
    int[] in = {3, 2, 4, 1, 6, 5, 7};
    int[] pre = {1, 2, 3, 4, 5, 6, 7};
    reConstructBinaryTree(pre, in);
    long l1 = System.currentTimeMillis();
    System.out.println(l1 - l);
  }
}

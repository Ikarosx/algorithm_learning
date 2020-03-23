package simple;

import org.junit.jupiter.api.Test;

/** @Author: Ikaros @Date: 2020/1/11 13:17 */
public class MaxDepth {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  @Test
  public void solution() {}
}

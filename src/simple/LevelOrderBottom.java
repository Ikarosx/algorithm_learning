package simple;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * <p>例如： 给定二叉树 [3,9,20,null,null,15,7],
 *
 * <p>3 / \ 9 20 / \ 15 7 返回其自底向上的层次遍历为：
 *
 * <p>[ [15,7], [9,20], [3] ]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 @Author: Ikaros @Date: 2020/1/12 20:22
 */
public class LevelOrderBottom {
  @Test
  public void solution() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    levelOrderBottom(root);
  }

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root == null) {
      return new LinkedList<>();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    List<List<Integer>> lists = new LinkedList<>();
    while (!queue.isEmpty()) {
      List<Integer> list = new LinkedList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode poll = queue.poll();
        if (poll.left != null) {
          queue.add(poll.left);
        }
        if (poll.right != null) {
          queue.add(poll.right);
        }
        list.add(poll.val);
      }
      lists.add(0, list);
    }

    return lists;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}

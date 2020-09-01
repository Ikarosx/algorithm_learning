package leetcode.剑指offer.N21_40;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;
import 剑指offer.TreeNode;

/**
 * @author Ikarosx
 * @date 2020/9/1 8:27
 */
public class N37序列化二叉树 {
  @Test
  public void test() {
    TreeNode treeNode = new TreeNode(1);
    treeNode.right = new TreeNode(2);
    System.out.println(serialize(treeNode));
  }

  public String serialize(TreeNode root) {
    if (root == null) {
      return "[]";
    }
    StringBuilder res = new StringBuilder("[");
    Queue<TreeNode> queue =
        new LinkedList<TreeNode>() {
          {
            add(root);
          }
        };
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node != null) {
        res.append(node.val).append(",");
        queue.add(node.left);
        queue.add(node.right);
      } else {
        res.append("null,");
      }
    }
    res.deleteCharAt(res.length() - 1);
    res.append("]");
    return res.toString();
  }

  public TreeNode deserialize(String data) {
    if (data.equals("[]")) {
      return null;
    }
    String[] vals = data.substring(1, data.length() - 1).split(",");
    TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
    Queue<TreeNode> queue =
        new LinkedList<TreeNode>() {
          {
            add(root);
          }
        };
    int i = 1;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (!vals[i].equals("null")) {
        node.left = new TreeNode(Integer.parseInt(vals[i]));
        queue.add(node.left);
      }
      i++;
      if (!vals[i].equals("null")) {
        node.right = new TreeNode(Integer.parseInt(vals[i]));
        queue.add(node.right);
      }
      i++;
    }
    return root;
  }
}

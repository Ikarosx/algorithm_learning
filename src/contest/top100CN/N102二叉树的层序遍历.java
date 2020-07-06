package contest.top100CN;

import 剑指offer.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author Ikaros
 * @date 2020/7/6 8:06
 */
public class N102二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        int count = 1;
        queue.add(root);
        int temp = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            while (count-- > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                    temp++;
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    temp++;
                }
            }
            result.add(list);
            count = temp;
            temp = 0;
        }
        return result;
    }
}

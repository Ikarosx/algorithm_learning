package 剑指offer.举例让抽象具体化.从上往下打印二叉树;

import org.junit.jupiter.api.Test;
import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @author Ikaros
 * @date 2020/03/12 23:47
 */
class SolutionTest {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return list;
    }
    
    @Test
    void solution() {
        long l = System.currentTimeMillis();
        int[][] arrays = {{1, 2}, {3, 4}};
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 3, 1, 2};
        PrintFromTopToBottom(null);
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}

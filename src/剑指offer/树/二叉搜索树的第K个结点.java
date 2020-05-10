package 剑指offer.树;

import 剑指offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）中，
 * 按结点数值大小顺序第三小结点的值为4。
 *
 * @author Ikaros
 * @date 2020/5/9 14:49
 */
public class 二叉搜索树的第K个结点 {
    // {8,6,10,5,7,9,11},1
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        int i = countLeftTree(pRoot);
        if (i + 1 == k) {
            return pRoot;
        } else if (i + 1 < k) {
            return KthNode(pRoot.right, k - i - 1);
        } else {
            return KthNode(pRoot.left, k);
        }
    }
    
    private int countLeftTree(TreeNode pRoot) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot != null && pRoot.left != null) {
            queue.add(pRoot.left);
        }
        while (!queue.isEmpty()) {
            result++;
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return result;
    }
}

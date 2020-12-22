package leetcode.sign;

import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;
import sort.helper.SortTestHelper;
import 剑指offer.TreeNode;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/12/22 12:06
 */
public class N103二叉树的锯齿形层序遍历 {
    @Test
    public void test(){

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        // 从左到右
        boolean flag = true;
        while (!deque.isEmpty()) {
            int count = deque.size();
            Deque<Integer> list = new LinkedList<>();
            while (count-- > 0) {
                TreeNode poll = deque.poll();
                if(flag) {
                    list.offerLast(poll.val);
                } else {
                    list.offerFirst(poll.val);
                }
                if (poll.left != null) {
                    deque.add(poll.left);
                }
                if (poll.right != null) {
                    deque.add(poll.right);
                }
            }

            flag = !flag;
            result.add(new LinkedList<>(list));
        }
        return result;
    }
}

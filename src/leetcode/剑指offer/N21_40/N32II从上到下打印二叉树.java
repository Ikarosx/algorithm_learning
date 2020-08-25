package leetcode.剑指offer.N21_40;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import 剑指offer.TreeNode;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 *
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikaros
 * @date 2020/08/25 10:15
 */
public class N32II从上到下打印二叉树 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 队列层序遍历
        if (root == null) {
            return new LinkedList<List<Integer>>() {
            };
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 记录还有多少个数当前层就结束
        int count = 1;
        // --------------- 优化-使用ArrayList顺序访问会快 ---------------
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            count--;
            temp.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
            if (count == 0) {
                count = queue.size();
                list.add(temp);
                temp = new LinkedList<>();
            }
        }
        return list;
    }
}

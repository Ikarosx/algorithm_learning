package leetcode.剑指offer.N21_40;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import 剑指offer.TreeNode;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 *
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikaros
 * @date 2020/08/26 07:59
 */
public class N34二叉树中和为某一值的路径 {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(-2);
        treeNode.right = new TreeNode(-3);
        System.out.println(pathSum(treeNode, -5));
    }

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        pathSumImpl(root, sum, list);
        return result;
    }

    private void pathSumImpl(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        // 如果当前的值已经等于sum
        // 因为可能在计算途中 = sum，所以还得继续计算
        if (root.val == sum && root.left == null && root.right == null) {
            // 必须是叶子结点才算路径
            list.add(root.val);
            List<Integer> integers = new ArrayList<>(list);
            result.add(integers);
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        pathSumImpl(root.left, sum - root.val, list);
        pathSumImpl(root.right, sum - root.val, list);
        list.remove(list.size() - 1);
    }
}

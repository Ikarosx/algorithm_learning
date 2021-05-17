package leetcode.序号.n900;

import org.junit.Test;
import 剑指offer.TreeNode;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对<em>堂兄弟节点</em>。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 * 示例 1：<br>
 * <img style="height: 160px; width: 180px;" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/q1248-01.png" alt="">
 * <p>
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * <p>
 * 示例 2：<br>
 * <img style="height: 160px; width: 201px;" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/q1248-02.png" alt="">
 * <p>
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * <p>
 * 示例 3：
 *
 * <img style="height: 160px; width: 156px;" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/q1248-03.png" alt="">
 * <p>
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点数介于&nbsp;2 到&nbsp;100&nbsp;之间。
 * 每个节点的值都是唯一的、范围为&nbsp;1 到&nbsp;100&nbsp;的整数。
 * <p>
 * <p>
 * 相关标签：
 * 树
 * 广度优先搜索
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/cousins-in-binary-tree/
 *
 * @author Ikarosx
 * @date 2021/5/17
 */
public class N993二叉树的堂兄弟节点 {
    private int xDepth = -1;
    private int yDepth = -2;
    private TreeNode xParent = null;
    private TreeNode yParent = null;

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
		System.out.println(isCousins(treeNode, 3, 4));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        findXY(root, x, y, 1, null);
        return xDepth == yDepth && xParent != yParent;
    }

    private void findXY(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            xDepth = depth;
            xParent = parent;
        }
        if (root.val == y) {
            yDepth = depth;
            yParent = parent;
        }
        findXY(root.left, x, y, depth + 1, root);
        findXY(root.right, x, y, depth + 1, root);
    }
}
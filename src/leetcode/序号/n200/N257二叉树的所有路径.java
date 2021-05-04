package leetcode.序号.n200;

import org.junit.Test;
import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明:&nbsp;叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 相关标签：
 * 树
 * 深度优先搜索
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/binary-tree-paths/
 *
 * @author Ikarosx
 * @date 2021/5/4
 */
public class N257二叉树的所有路径 {
    public List<String> strings = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return strings;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.val);
        binaryTreePathsImpl(root, stringBuilder);
        return strings;
    }

	/**
	 * 利用sb优化
	 * 2ms 77%
	 * 38.5MB 84%
	 * @param root
	 * @param stringBuilder
	 */
	private void binaryTreePathsImpl(TreeNode root, StringBuilder stringBuilder) {
        if (root.left == null && root.right == null) {
            strings.add(stringBuilder.toString());
            return;
        }
        if (root.left != null) {
            binaryTreePathsImpl(root.left, stringBuilder.append("->").append(root.left.val));
            stringBuilder.delete(stringBuilder.length() - String.valueOf(root.left.val).length() - 2, stringBuilder.length());
        }
        if (root.right != null) {
            binaryTreePathsImpl(root.right, stringBuilder.append("->").append(root.right.val));
			stringBuilder.delete(stringBuilder.length() - String.valueOf(root.right.val).length() - 2, stringBuilder.length());
        }
    }
}
package leetcode.序号.n600;

import 剑指offer.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * 案例 1:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * 输出: True
 * <p>
 * 案例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * 输出: False
 * <p>
 * <p>
 * 相关标签：
 * 树
 * 深度优先搜索
 * 广度优先搜索
 * 二叉搜索树
 * 哈希表
 * 双指针
 * 二叉树
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 *
 * @author Ikarosx
 * @date 2021/7/13
 */
public class N653两数之和IV {
    private Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);

		return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
package leetcode.序号.n500;

import 剑指offer.TreeNode;

/**
 * 给定两个非空二叉树 s 和 t，检验&nbsp;s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:<br>
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * <p>
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * <p>
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 2:<br>
 * 给定的树 s：
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * <p>
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * <p>
 * 返回 false。
 * <p>
 * 相关标签：
 * 树
 * 深度优先搜索
 * 二叉树
 * 字符串匹配
 * 哈希函数
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/subtree-of-another-tree/
 *
 * @author Ikarosx
 * @date 2021/7/7
 */
public class N572另一个树的子树 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	// 普通DFS
		// KMP
		// 树哈希
        return dfs(s, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }
}
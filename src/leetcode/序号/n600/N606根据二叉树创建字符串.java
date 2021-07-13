package leetcode.序号.n600;

import 剑指offer.TreeNode;

/**
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * <p>
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 二叉树: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * 输出: "1(2(4))(3)"
 * <p>
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * <p>
 * 示例 2:
 * <p>
 * 输入: 二叉树: [1,2,3,null,4]
 * 1
 * /   \
 * 2     3
 * \
 * 4
 * <p>
 * 输出: "1(2()(4))(3)"
 * <p>
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 * <p>
 * <p>
 * 相关标签：
 * 树
 * 深度优先搜索
 * 字符串
 * 二叉树
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 *
 * @author Ikarosx
 * @date 2021/7/13
 */
public class N606根据二叉树创建字符串 {
    public String tree2str(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        tree2strImpl(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void tree2strImpl(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.val);
		if (root.left != null) {
			sb.append('(');
			tree2strImpl(root.left, sb);
			sb.append(')');
		}
		if (root.right != null) {
			if (root.left == null) {
				sb.append("()");
			}
			sb.append('(');
			tree2strImpl(root.right, sb);
			sb.append(')');
		}
    }
}
package leetcode.序号.n500;

import 剑指offer.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * 例如：<br>
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * <p>
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * <p>
 * 相关标签：
 * 树
 * 深度优先搜索
 * 二叉搜索树
 * 二叉树
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 *
 * @author Ikarosx
 * @date 2021/7/8
 */
public class N501二叉搜索树中的众数 {
    private List<Integer> list = new LinkedList<>();
    private int pre = 0;
    private int count = 0;
    private int max = 0;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] result = new int[list.size()];  //初始化数组
        for (int i = 0; i < list.size(); i++) {  //list转array
            result[i] = list.get(i);
        }
        return result;

    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dealValue(root.val);
        dfs(root.right);
    }

    private void dealValue(int val) {
        if (val == pre) {
            count++;
        } else {
            pre = val;
            count = 1;
        }
        if (count == max) {   //如果是最大个数
            list.add(val); //加入list里
        } else if (count > max) {   //如果超过最大个数
            list.clear();   //清空整个list
            list.add(val); //加入list里（新的max）
            max = count;    //刷新max
        }


    }
}
package 剑指offer.树;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @author Ikaros
 * @date 2020/5/9 9:51
 */
public class 按之字形打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        stack1.add(pRoot);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode pop = stack1.pop();
                list.add(pop.val);
                if (pop.left != null) {
                    stack2.add(pop.left);
                }
                if (pop.right != null) {
                    stack2.add(pop.right);
                }
            }
            if (list.size() != 0) {
                result.add(list);
            }
            ArrayList<Integer> list2 = new ArrayList<>();
            while (!stack2.isEmpty()) {
                TreeNode pop = stack2.pop();
                list2.add(pop.val);
                if (pop.right != null) {
                    stack1.add(pop.right);
                }
                if (pop.left != null) {
                    stack1.add(pop.left);
                }
            }
            if (list2.size() != 0) {
                result.add(list2);
            }
        }
        return result;
    }
}

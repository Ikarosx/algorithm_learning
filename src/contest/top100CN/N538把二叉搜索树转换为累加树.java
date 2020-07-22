package contest.top100CN;

import 剑指offer.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 *
 * @author Ikarosx
 * @date 2020/7/21 13:13
 */
public class N538把二叉搜索树转换为累加树 {
    private int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
    
}

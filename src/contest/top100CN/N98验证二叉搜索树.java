package contest.top100CN;

import 剑指offer.TreeNode;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author Ikaros
 * @date 2020/7/5 23:57
 */
public class N98验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return isvalidBSTImpl(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isvalidBSTImpl(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isvalidBSTImpl(root.left, min, root.val) && isvalidBSTImpl(root.right, root.val, max);
    }
}

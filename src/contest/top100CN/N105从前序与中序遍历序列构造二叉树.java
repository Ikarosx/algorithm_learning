package contest.top100CN;

import org.junit.jupiter.api.Test;
import 剑指offer.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author Ikarosx
 * @date 2020/7/7 7:52
 */
public class N105从前序与中序遍历序列构造二叉树 {
    @Test
    public void test() {
        buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        // preorder 为空，直接返回 null
        if (pl == pr) {
            return null;
        }
        int root_val = preorder[pl];
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int temp = 0;
        for (int i = il; i < ir; i++) {
            if (root_val == inorder[i]) {
                temp = i;
                break;
            }
        }
        int d = temp - il;
        //递归的构造左子树
        root.left = buildTreeHelper(preorder, pl + 1, pl + d + 1, inorder, il, temp);
        //递归的构造右子树
        root.right = buildTreeHelper(preorder, pl + d + 1, pr, inorder, temp + 1, ir);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTreeImpl(preorder, 0, preorder.length , inorder, 0, preorder.length);
    }
    
    private TreeNode buildTreeImpl(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl == pr) {
            return null;
        }
        int root = preorder[pl];
        TreeNode treeNode = new TreeNode(root);
        int temp = 0;
        for (int i = il; i < ir; i++) {
            if (inorder[i] == root) {
                temp = i;
                break;
            }
        }
        int d = temp - il;
        treeNode.left = buildTreeImpl(preorder, pl + 1, pl + d + 1, inorder, il, temp);
        treeNode.right = buildTreeImpl(preorder, pl + d + 1, pr, inorder, temp + 1, ir);
        return treeNode;
    }
}

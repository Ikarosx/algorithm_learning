package leetcode.剑指offer.N1_20;

import java.util.HashMap;
import java.util.Map;
import 剑指offer.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 *
 * @author Ikarosx
 * @date 2020/8/21 22:22
 */
public class N07重建二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        // --------------- 优化-空间换时间 ---------------
        Map<Integer, Integer> indexMap = new HashMap<>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeImpl(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1,
            indexMap);
    }

    private TreeNode buildTreeImpl(int[] preorder, int pl, int pr, int[] inorder, int il, int ir,
        Map<Integer, Integer> map) {
        if (pl > pr || il > ir) {
            return null;
        }
        // 前序遍历第一个为根节点
        TreeNode root = new TreeNode(preorder[pl]);

        // --------------- 优化-提前结束 ---------------
        if (pl == pr) {
            return root;
        }
        // 中序遍历中根节点的下标
        int rootInInorder = map.get(root.val);
        // 左部分的长度
        int llength = rootInInorder - il;
        // 构建左子树
        root.left = buildTreeImpl(preorder, pl + 1, pl + llength, inorder, il, rootInInorder - 1,
            map);
        // 构建右子树
        root.right = buildTreeImpl(preorder, pl + llength + 1, pr, inorder, rootInInorder + 1, ir,
            map);
        return root;
    }
}

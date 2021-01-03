package leetcode.序号.n100;

import 剑指offer.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * 通过次数131,493提交次数176,313
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/3 18:57
 */
public class N108将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (r - l) / 2 + l;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = dfs(nums, l, mid - 1);
        treeNode.right = dfs(nums, mid + 1, r);
        return treeNode;
    }

}

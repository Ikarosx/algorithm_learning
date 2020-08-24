package leetcode.剑指offer.N21_40;

import 剑指offer.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/8/24 17:36
 */
public class N26树的子结构 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 两者都为空
        if (A == null && B == null) {
            return true;
        }
        // 其中一者为空
        if (A == null || B == null) {
            return false;
        }
        // 两者都不为空
        if (A.val == B.val) {
            // 如果两值相同
            if (isSubStructureImpl(A, B)) {
                return true;
            }
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSubStructureImpl(TreeNode A, TreeNode B) {
        // 只要B为空则说明返回true
        if (B == null) {
            return true;
        }
        // B不为空A为空说明false
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return isSubStructureImpl(A.left, B.left) && isSubStructureImpl(A.right, B.right);
    }
}

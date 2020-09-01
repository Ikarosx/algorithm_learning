package leetcode.剑指offer.N21_40;

import org.junit.Assert;
import org.junit.Test;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *  
 *
 * 参考以下这颗二叉搜索树：
 *
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/8/26 6:56
 */
public class N33二叉搜索树的后序遍历序列 {

    @Test
    public void test() {
        Assert.assertTrue(verifyPostorder(new int[]{1, 3, 2, 6, 5}));
        Assert.assertFalse(verifyPostorder(new int[]{1, 6, 3, 2, 5}));
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        // 最后边一个肯定是根
        // 且数组分为三部分 | 左边 | 右边 | 根 |
        // 左边部分全部小于根
        // 右边部分全部大于根
        return verifyPostorderImpl(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorderImpl(int[] postorder, int l, int r) {
        if (l >= r) {
            return true;
        }
        int root = postorder[r];
        // 找到右边最后一个大于root,使得postorder[n] < root
        int n;
        for (n = r - 1; n >= l && postorder[n] > root; n--) {
        }
        // 此时n应该为 l - 1 / postorder[n] < root
        for (int i = l; i <= n; i++) {
            if (postorder[i] > root) {
                return false;
            }
        }
        return verifyPostorderImpl(postorder, l, n) && verifyPostorderImpl(postorder, n + 1, r - 1);
    }
}

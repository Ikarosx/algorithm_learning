package leetcode.序号.n300;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如&nbsp; sqrt 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：num = 14
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 2^31 - 1
 * <p>
 * <p>
 * 相关标签：
 * 数学
 * 二分查找
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/valid-perfect-square/
 *
 * @author Ikarosx
 * @date 2021/6/28
 */
public class N367有效的完全平方数 {
    @Test
    public void test() {
        Assert.assertTrue(isPerfectSquare(1));
        Assert.assertTrue(isPerfectSquare(4));
        Assert.assertTrue(isPerfectSquare(9));
        Assert.assertFalse(isPerfectSquare(10));
        Assert.assertFalse(isPerfectSquare(11));
        Assert.assertFalse(isPerfectSquare(12));
    }

    /**
     * 二分法
     */
    public boolean isPerfectSquare(int num) {

        long l = 1;
        long r = num / 2;
        while (l <= r) {
            long mid = (l + r) / 2;
            long temp = mid * mid;
            if (temp == num) {
                return true;
            }
            if (temp < num) {
                l = mid + 1;
                continue;
            }
            if (temp > num) {
                r = mid - 1;
                continue;
            }

        }
        return num == 1;
    }
    // 牛顿迭代
}
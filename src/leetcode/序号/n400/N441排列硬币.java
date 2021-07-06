package leetcode.序号.n400;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * 你总共有&nbsp;<em>n&nbsp;</em>枚硬币，你需要将它们摆成一个阶梯形状，第&nbsp;<em>k&nbsp;</em>行就必须正好有&nbsp;<em>k&nbsp;</em>枚硬币。
 * <p>
 * 给定一个数字&nbsp;<em>n</em>，找出可形成完整阶梯行的总行数。
 *
 * <em>n&nbsp;</em>是一个非负整数，并且在32位有符号整型的范围内。
 * <p>
 * 示例 1:
 * <p>
 * n = 5
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第三行不完整，所以返回2.
 * <p>
 * 示例 2:
 * <p>
 * n = 8
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第四行不完整，所以返回3.
 * <p>
 * <p>
 * 相关标签：
 * 数学
 * 二分查找
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/arranging-coins/
 *
 * @author Ikarosx
 * @date 2021/7/6
 */
public class N441排列硬币 {
    @Test
    public void test() {
        Assertions.assertEquals(2, arrangeCoins(5));
        Assertions.assertEquals(3, arrangeCoins(8));
        Assertions.assertEquals(3, arrangeCoins(9));
        Assertions.assertEquals(4, arrangeCoins(10));
        Assertions.assertEquals(60070, arrangeCoins(1804289383));
    }

    public int arrangeCoins(int n) {
    	// 二分
        int l = 0;
        long d = n;
        int r = (int) Math.sqrt(2 * d);
        while (l <= r) {
            int mid = (l + r) / 2;
            long sum = (long) (1 + mid) * mid;
            if (sum > 2 * d) {
                r = mid - 1;
            } else if (sum < 2 * d) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return r;
    }

    private int getAnInt(int n) {
        return (1 + n) * n;
    }
}
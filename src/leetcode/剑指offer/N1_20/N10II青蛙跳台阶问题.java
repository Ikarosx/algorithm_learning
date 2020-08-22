package leetcode.剑指offer.N1_20;

import org.junit.Test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/8/22 7:35
 */
public class N10II青蛙跳台阶问题 {

    @Test
    public void test() {
        assert numWays(2) == 2;
        assert numWays(7) == 21;
        assert numWays(0) == 1;
    }

    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        // 跳到当前台阶的前两阶的跳法
        int bb = 1;
        // 跳到当前台阶的前一阶的跳法
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = b;
            // 本质上还是斐波那切
            b += bb;
            b %= 1e9 + 7;
            bb = temp;
        }
        return b;
    }

}

package leetcode.剑指offer.N1_20;

import org.junit.Test;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/8/23 7:35
 */
public class N16数值的整数次方 {

    @Test
    public void test() {
        assert myPow(2.0, 10) == 1024.0;
        System.out.println(myPow(2.1, 3));
        assert myPow(2.1, 3) == 9.261;
        System.out.println(myPow(2.0, -2));
        assert myPow(2.0, -2) == 0.25;
    }

    /**
     * 快速幂
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        // 解决b=Integer.MIN_VALUE时，b=-b时可能越界
        long b = n;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        double result = 1.0;
        while (b > 0) {
            if ((b & 1) == 1) {
                result *= x;
            }
            x *= x;
            b >>= 1;
        }
        return result;
    }

}

package leetcode.剑指offer.N1_20;

import org.junit.Test;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/8/22 7:20
 */
public class N10I斐波那契数列 {

    @Test
    public void test() {
        assert fib(2) == 1;
        assert fib(5) == 5;
    }

    public int fib(int n) {
        // 0返回0，1返回1
        if (n <= 1) {
            return n;
        }
        // 两个变量记录
        int before = 0;
        int current = 1;

        for (int i = 2; i <= n; i++) {
            // 记录当前值
            int temp = current;
            // 更新当前值为两个值之和
            current += before;
            current %= 1e9 + 7;
            // 前一个值更新为旧当前值
            before = temp;
        }
        return current;
    }
}

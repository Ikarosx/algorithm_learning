package leetcode.剑指offer.N1_20;

import org.junit.Test;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/8/23 7:31
 */
public class N15二进制中1的个数 {

    @Test
    public void test() {
        assert hammingWeight(8) == 1;
        assert hammingWeight(9) == 2;
    }

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            // n & n - 1 会导致右边的第一个1去掉
            n &= n - 1;
        }
        return result;
    }
}

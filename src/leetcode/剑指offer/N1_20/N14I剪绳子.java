package leetcode.剑指offer.N1_20;

import org.junit.Test;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/8/22 20:39
 */
public class N14I剪绳子 {

    @Test
    public void test() {
        assert cuttingRope(2) == 1;
        assert cuttingRope(10) == 36;
    }

    public int cuttingRope(int n) {
        // 经数学可得。。当每段绳子长度为e时乘积最大
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int result = 1;
        while (n > 4) {
            n -= 3;
            result *= 3;
        }
        // 当n = 4 时，特殊 2 * 2 = 4 > 1 * 3
        return result * n;
    }

    /**
     * 动态规划
     */
    public int cuttingRopeByDP(int n) {
        // ints[i]表示长度为n的绳子裁剪后能得到的最大乘积
        int[] ints = new int[n + 1];
        ints[1] = 1;
        ints[2] = 1;
        // 从长度3开始
        for (int i = 3; i <= n; i++) {
            // 默认以自己不裁剪
            int max = 0;
            for (int j = 1; j <= (i - 2) / 2 + 1; j++) {
                max = Math.max(max, Math.max(j * (i - j), ints[i - j] * j));
            }
            ints[i] = max;
        }
        return ints[n];
    }
}

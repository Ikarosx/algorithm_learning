package leetcode.序号.n200;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 统计所有小于非负整数&nbsp;<em>n&nbsp;</em>的质数的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 5 * 10<sup>6</sup>
 * <p>
 * <p>
 * 相关标签：
 * 哈希表
 * 数学
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/count-primes/
 *
 * @author Ikarosx
 * @date 2021/4/26
 */
public class N204计数质数 {


    @Test
    public void test() {
        Assert.assertEquals(4, countPrimes(10));
        Assert.assertEquals(0, countPrimes(0));
        Assert.assertEquals(0, countPrimes(1));
        Assert.assertEquals(9, countPrimes(29));
        Assert.assertEquals(10, countPrimes(499979));
    }

    public int countPrimes(int n) {
        // 筛素数
        boolean[] ints = new boolean[n];
        int result = 0;
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (ints[i]) {
                continue;
            }
            result++;
            for (int j = i + i; j < n; j += i) {
                ints[j] = true;
            }
            primes.add(i);
        }
        return result;
    }
}
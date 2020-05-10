package 剑指offer.动态规划与贪婪;

import org.junit.jupiter.api.Test;

/**
 * 给你一根长度为n的绳子，
 * 请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * @author Ikaros
 * @date 2020/5/9 19:32
 */
public class 剪绳子 {
    @Test
    public void test() {
        System.out.println(cutRope(8));
    }
    
    public int cutRope(int target) {
        if (target < 1) {
            return 0;
        }
        if (target == 2 || target == 3) {
            return target - 1;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max = 0;
        for (int i = 4; i < dp.length; i++) {
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(dp[j] * dp[i - j], max);
            }
            dp[i] = max;
        }
        return max;
    }
}
